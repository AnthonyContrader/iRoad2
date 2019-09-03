import React from 'react'
import ReactDOM from 'react-dom'
import './index.css'
import {
  Route,
  NavLink,
  BrowserRouter as Router,
  Switch,
} from 'react-router-dom'
import App from './App'
import Company from './Company'


import Candidato from './Candidato';
const routing = (
  <Router>
    <div>
      <ul>
        <li>
          <NavLink exact activeClassName="active" to="/App">
            Home
          </NavLink>
        </li>
        <li>
          <NavLink activeClassName="active" to="/Company">
            Company
          </NavLink>
        </li>
        <li>
          <NavLink activeClassName="active" to="/Candidato">
            Candidato
          </NavLink>
        </li>
      </ul>
      <hr />
      <Switch>
        <Route exact path="/App" component={App} />
        <Route path="/Candidato" component={Candidato} />
        <Route path="/Company" component={Company} />
       
      </Switch>
    </div>
  </Router>
)
ReactDOM.render(routing, document.getElementById('root'))