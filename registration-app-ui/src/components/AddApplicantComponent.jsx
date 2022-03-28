import React, {Component} from 'react';

import {withRouter} from "react-router-dom";
import ApplicantService from "../services/ApplicantService";
import styles from './applicantStyles.module.css'

class AddApplicantComponent extends Component {
	constructor(props){
		super(props)

		this.state = {
			id: '',
			firstName: '',
			lastName: '',
			error:''
		}
		this.changeIdHandler = this.changeIdHandler.bind(this);
		this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
		this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
		this.saveApplicant = this.saveApplicant.bind(this);
		this.cancel = this.cancel.bind(this);
	}
	changeIdHandler = (event) => {
		this.setState({id: event.target.value});
	}
	changeFirstNameHandler = (event) => {
		this.setState({firstName: event.target.value});
	}
	changeLastNameHandler = (event) => {
		this.setState({lastName: event.target.value});
	}

	saveApplicant = (c) => {
		c.preventDefault();
		if(this.state.firstName.length < 1 )
		{
			this.setState({error: " First name is a required field * "});
		}
		else if(this.state.lastName.length < 1){
			this.setState({error: " Last name is a required field * "});
		}
		else
		{
			let applicant = {id: this.state.id, firstName: this.state.firstName, lastName: this.state.lastName}
			console.log('applicant =>' + JSON.stringify(applicant));
			ApplicantService.addApplicant(applicant).then(res => {
				this.props.history.push("/applicants");
			}).catch((error) => this.setState({error:"Error: id "+ this.state.id+" is invalid"}));
		}
	}
	cancel() {
		this.props.history.push('/applicants');
	}
	render()
	{
		const {error} = this.state;
		return (
				<div>
					<div className="container">
						<div className="row">
							<div className="card col-md-6 offset-md-3 offset-md-3">
								<h3 className="text-center">Add Applicant</h3>
								<div className="card-body">
									<form>
										<div className="form-group.required">
											<label> Applicant ID: </label>
											<input placeholder="XXXXXXXXXXXXXXX" name="id" className="form-control"
													value={this.state.id} onChange={this.changeIdHandler}/>
										</div>
										<div className="form-group.required">
											<label> First Name: </label>
											<input placeholder="Sabre" name="firstName" className="form-control"
													value={this.state.firstName} onChange={this.changeFirstNameHandler}/>
										</div>
										<div className="form-group.required">
											<label> Last Name: </label>
											<input placeholder="Didi" name="lastName" className="form-control"
													value={this.state.lastName} onChange={this.changeLastNameHandler}/>
										</div>
										<button className="btn btn-success" onClick={this.saveApplicant}>Save</button>
										<button className="btn btn-danger" onClick={this.cancel} style={{marginLeft:"10px"}}>Cancel</button>
										<span className={styles.mystyle}><label> {error} </label></span>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
		);
	}
}

export default withRouter(AddApplicantComponent);