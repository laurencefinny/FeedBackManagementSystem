import React from 'react';
import { BootstrapTable, TableHeaderColumn } from 'react-bootstrap-table-plus';
import Axios from 'axios';

class Role extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            data: [],
            user: [],
            newUser: []
        }

        this.filterNames = this.filterNames.bind(this);
        this.getValueInput = this.getValueInput.bind(this);
    }

    componentDidMount = () => {



        Axios.get('http://localhost:8060/authentication-service/users', { headers: { 'Content-Type': 'application/json', 'Authorization': `Bearer ${localStorage.getItem("token")}` } }).then(res => {

            if (res.status == '200') {
                this.userTableHandler(res.data)

            }
        }).catch(function (error) {
            console.log("error:", error);
        });

        Axios.get('http://localhost:8060/event-report-service/getUser', { headers: { 'Content-Type': 'application/json', 'Authorization': `Bearer ${localStorage.getItem("token")}` } }).then(res => {

            if (res.status == '200') {
                this.eventTableHandler(res.data)

            }
        }).catch(function (error) {
            console.log("error:", error);
        });

    }
    eventTableHandler = (eventdata) => {
        eventdata.filter((event) => {
            let name = event.body.employee_name.split(" ")

            let user = {

                us_fs_name: name[0],
                us_ls_name: name[1],
                us_emp_id: event.body.employee_id.toString(),

            }

            this.state.user.push(user)

        })
        this.setState({ user: this.state.user })

    }

    getValueInput(evt) {
        const inputValue = evt.target.value;
        this.setState({ input: inputValue });
        this.filterNames(inputValue);
    }

    filterNames(inputValue) {

        this.setState({
            newUser: this.state.user.filter(item =>
                item.us_emp_id.includes(inputValue))

        });
       
    }

    userTableHandler = (userdata) => {
        userdata.filter((user) => {
            if (user.body.role == "Pmo") {
                this.state.data.push(user.body)
            }
        })
        this.setState({ data: this.state.data })

    }
    addOrDelete = (e) => {
       
        if (e.target.id === "Add") {
            console.log(this.state)
            if (this.state.newUser.length > 0) {
                if (window.confirm('Are you sure you want to Add this User ' + this.state.newUser[0].us_fs_name + ' ?')) {
                    // history.push('/questions/')

                    let add = this.state.input + " " + this.state.newUser[0].us_fs_name + " " + this.state.newUser[0].us_ls_name;
                    console.log(add)
                    if (this.state.newUser.length > 1) {
                        Axios.post('http://localhost:8060/authentication-service/users/', [add], { headers: { 'Content-Type': 'application/json', 'Authorization': `Bearer ${localStorage.getItem("token")}` } })
                            .then((response) => {
                                console.log(response);
                            }, (error) => {
                                alert("User Already Registered")
                                console.log(error);
                            });
                    } 

                }
            } else {
                alert("Invalid User")
            }

        } else {
            if (window.confirm('Are you sure you want to Delete this User ' + this.state.newUser[0].us_fs_name + ' ?')) {
                Axios.delete('http://localhost:8060/authentication-service/users/' + this.state.input, { headers: { 'Content-Type': 'application/json', 'Authorization': `Bearer ${localStorage.getItem("token")}` } })
                    .then((response) => {
                        console.log(response);
                    }, (error) => {
                        console.log(error);
                    });

                // history.push('/questions/')
            }
        }


    }

    render() {

        const options = {
            prePage: 'Prev',
            nextPage: 'Next',
            firstPage: 'First',
            lastPage: 'Last',
            hideSizePerPage: true,

        };

        if (localStorage.getItem("role") == "Admin") {
            return (

                <div className="container-fluid">

                    <div >
                        <div className="py-2 text-white" style={{ backgroundColor: '#0000b3' }}> <h5 className="font-weight-bold ml-3">Assign Pmo</h5></div>
                        <div className="row py-2 justify-content-lg-center">
                            <div className="col-9 col-sm-4 ml-2"><h5 className="mb-2" >Employee ID <label className="ml-1 mt-1"><input type="search" value={this.state.newUser.us_emp_id} onKeyUp={this.getValueInput} className="form-control-sm" placeholder="Enter Email Address" /></label></h5></div>

                            <div className="col-sm-4">
                                <button type="submit" className=" ml-2  btn-success font-weight-bold" id={"Add"} onClick={this.addOrDelete}>Add Pmo</button>
                                <button type="button" className=" ml-2 btn-danger font-weight-bold" onClick={this.addOrDelete}>Remove Pmo</button>
                            </div>
                        </div>
                    </div>

                    <div>

                        <div className="py-2 mb-2 text-white" style={{ backgroundColor: '#0000b3' }}> <h5 className="font-weight-bold ml-3">Pmo Users</h5></div>
                        <div >
                            <BootstrapTable data={this.state.data} options={options} pagination >
                                <TableHeaderColumn dataField='us_emp_id' isKey className="event-table-th">Employee ID</TableHeaderColumn>
                                <TableHeaderColumn dataField='us_fs_name' className="event-table-th">First Name</TableHeaderColumn>
                                <TableHeaderColumn dataField='us_ls_name' className="event-table-th">Last Name</TableHeaderColumn>
                            </BootstrapTable>
                        </div>
                    </div>

                </div>
            )
        } else {
            return (
                <div className="container">
                <div className="alert alert-danger  alert-dismissible  col-lg-9 col-md-9 col-sm-12 ">
                    <button type="button" className="close" data-dismiss="alert">&times;</button>
                    <strong><i className="fa fa-exclamation-triangle mr-1"></i>Warning!</strong> <text> Only Admin have the privileges to access this site</text>
                </div>
                </div>
            )
        }

    }
}
export default Role;