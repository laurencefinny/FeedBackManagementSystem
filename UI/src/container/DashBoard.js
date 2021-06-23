import React from 'react';
import Axios from 'axios';
import { connect } from 'react-redux';
import './DashBoard.css';
import { Link } from "mdbreact";
import Loading from '../component/Loading';

class DashBoard extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            totalEvents: 0,
            livesImpacted: 0,
            totalVolunteers: 0,
            totalParticipants: 0,
            dataFetch: false
        }
        this.addEvent = this.addEvent.bind(this)
    }
    addEvent () {
        
        Axios.get('http://localhost:8060/event-report-service/importEvent', { headers: { 'Content-Type': 'application/json', 'Authorization': `Bearer ${localStorage.getItem("token")}` } }).then(res => {

            if (res.status == '200') {
               console.log("event file processed sucessfully")

            }
        }).catch(function (error) {
            console.log("error:", error);
        });
        Axios.get('http://localhost:8060/event-report-service/importEventSum', { headers: { 'Content-Type': 'application/json', 'Authorization': `Bearer ${localStorage.getItem("token")}` } }).then(res => {

            if (res.status == '200') {
               console.log("event file processed sucessfully")

            }
        }).catch(function (error) {
            console.log("error:", error);
        });

    }
    componentDidMount = () => {

        if (localStorage.getItem("role") == 'Admin' || localStorage.getItem("role") == 'Pmo') {
            Axios.get('http://localhost:8060/event-report-service/dashboard/', { headers: { 'Content-Type': 'application/json', 'Authorization': `Bearer ${localStorage.getItem("token")}` } }).then(res => {

                if (res.status == '200') {
                    this.setState({ totalEvents: res.data.totalEvents })
                    this.setState({ livesImpacted: res.data.livesImpacted })
                    this.setState({ totalVolunteers: res.data.totalVolunteers })
                    this.setState({ totalParticipants: res.data.totalParticipants })
                }
            }).catch(function (error) {
                console.log("error:", error);
            });
        } else {
            Axios.get('http://localhost:8060/event-report-service/dashboard/' + localStorage.getItem("userEmpId"), { headers: { 'Content-Type': 'application/json', 'Authorization': `Bearer ${localStorage.getItem("token")}` } }).then(res => {

                if (res.status == '200') {
                    this.setState({ totalEvents: res.data.totalEvents })
                    this.setState({ livesImpacted: res.data.livesImpacted })
                    this.setState({ totalVolunteers: res.data.totalVolunteers })
                    this.setState({ totalParticipants: res.data.totalParticipants })
                }
            }).catch(function (error) {
                console.log("error:", error);
            });
        }

    }

    render() {


        return (
            <div>
                <div className="container-fluid">
                    {localStorage.getItem("role") == "Admin" ?
                        < div className="alert alert-success  alert-dismissible  col-lg-9 col-md-9 col-sm-12 py-1">
                            <button type="button" className="close" data-dismiss="alert">&times;</button>
                            <label className="btn btn py-1" onClick={this.addEvent}><strong><i className="fa fa-upload mr-2"></i>Add/Upload</strong></label> <text> Click here to Process the Event Files</text>
                        </div>
                        : ''}
                    <div className="row mb-3 mt-2">
                        <div className="col-xl-3 col-sm-6 py-2">
                            <div className="card bg-success text-white h-100">
                                <div className="card-body bg-sccess">
                                    <div className="rotate">
                                        <i className="fa fa-desktop fa-4x"></i>
                                    </div>
                                    <h6 className="text-uppercase">Total Events</h6>
                                    <h1 className="display-4">{this.state.totalEvents}</h1>
                                </div>
                                <div className="card bg-transparent text-right ">
                                    <Link className="h-25" to="/event">  <small className="text-muted text-light mr-3"> View Detail &nbsp; <i className="fa fa-caret-down"></i></small>
                                    </Link>
                                </div>
                            </div>
                        </div>

                        <div className="col-xl-3 col-sm-6 py-2">
                            <div className="card text-white bg-danger h-100">
                                <div className="card-body bg-danger">
                                    <div className="rotate">
                                        <i className="fa fa-link fa-4x"></i>
                                    </div>
                                    <h6 className="text-uppercase">Lives impacted</h6>
                                    <h1 className="display-4">{this.state.livesImpacted}</h1>
                                </div>
                                <div className="card bg-transparent text-right">
                                    <Link className="h-25" to="/event">  <small className="text-muted text-light mr-3"> View Detail &nbsp; <i className="fa fa-caret-down"></i></small>
                                    </Link>
                                </div>
                            </div>
                        </div>

                        <div className="col-xl-3 col-sm-6 py-2">
                            <div className="card text-white bg-info h-100">
                                <div className="card-body bg-info">
                                    <div className="rotate">
                                        <i className="fa fa-users fa-4x"></i>
                                    </div>
                                    <h6 className="text-uppercase">Total Volunteers</h6>
                                    <h1 className="display-4">{this.state.totalVolunteers}</h1>
                                </div>
                                <div className="card bg-transparent text-right">
                                    <Link className="h-25" to="/event">  <small className="text-muted text-light mr-3"> View Detail &nbsp; <i className="fa fa-caret-down"></i></small>
                                    </Link>
                                </div>
                            </div>
                        </div>


                        <div className="col-xl-3 col-sm-6 py-2 ">
                            <div className="card text-white bg-secondary h-100">
                                <div className="card-body">
                                    <div className="rotate">
                                        <i className="fa fa-clock fa-4x"></i>
                                    </div>
                                    <h6 className="text-uppercase">Total Participants</h6>
                                    <h1 className="display-4">{this.state.totalParticipants}</h1>
                                </div>
                                <div className="card bg-transparent text-right">
                                    <Link className="h-25" to="/event">  <small className="text-muted text-light mr-3"> View Detail &nbsp; <i className="fa fa-caret-down"></i></small>
                                    </Link>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div >
        )
    }
}
const mapStateToProps = state => {
    return {
        Users: state.userData

    };
};
export default connect(mapStateToProps, null)(DashBoard);
