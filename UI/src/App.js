import React from 'react';
import './App.css';
import { Router } from 'react-router-dom';
import { Route, Switch } from 'react-router';
import Login from './container/Login';
import DashBoard from './container/DashBoard';
import Event from './container/Event';
import Report from './container/Report';
import EventDetails from './component/EventDetails';
import Role from './container/Role';
import feedBackQues from './container/FeedBackQues';
import AddQues from './container/AddQues';
import EditQues from './container/EditQues';
import Header from './component/Header';
import Footer from './component/Footer';
import history from './redux/history';
import Forget from './container/forgetPassword';
import Reset from './container/resetPassword';

function App() {

  return (

    <Router history={history} >

      {
        window.location.pathname === '/' ? '' : <Header />
      }
      <Switch>
        <Route path="/reset" component={Reset} />
        <Route path="/forget" component={Forget} />
        <Route path="/dashboard" component={DashBoard} />
        <Route path="/event" component={Event} />
        <Route path="/report" component={Report} />
        <Route path="/details/:id" component={EventDetails} />
        <Route path="/role" component={Role} />
        <Route path="/questions" component={feedBackQues} />
        <Route path="/add-question/" component={AddQues} />
        <Route path="/edit-question/:id" component={EditQues} />
      </Switch>
      {
        window.location.pathname === '/' ? '' : <Footer />
      }
      <Route exact path="/" component={Login} />
    </Router>
  );
}

export default App;
