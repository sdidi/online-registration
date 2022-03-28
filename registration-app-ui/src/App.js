import './App.css';
import React, { Component } from 'react';
import {BrowserRouter as Router, Route, Switch, withRouter} from "react-router-dom";
import ListApplicantsComponent from "./components/ListApplicantsComponent";
import AddApplicantComponent from "./components/AddApplicantComponent";
import UpdateApplicantComponent from "./components/UpdateApplicantComponent";
import NavigationBarComponent from "./components/NavigationBarComponent";
import FooterComponent from "./components/FooterComponent";
import ErrorHandlingComponent from "./components/ErrorHandlingComponent";

function App() {
  return (
    <div>
		<Router>
			{/*<HeaderComponent/>*/}
			<NavigationBarComponent/>
			<div className="container">
				<Switch>
					 <Route path = "/applicants">
						 <ErrorHandlingComponent>
							 <ListApplicantsComponent/>
						 </ErrorHandlingComponent>
					</Route>
					<Route path = "/addapplicant">
						<AddApplicantComponent/>
					</Route>
					<Route path = "/editapplicant/:id">
						<UpdateApplicantComponent/>
					</Route>
				</Switch>
			</div>
			<FooterComponent/>
		</Router>
    </div>
  );
}

export default withRouter(App);
