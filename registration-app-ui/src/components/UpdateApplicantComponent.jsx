import React, {Component} from 'react';
import ApplicantService from "../services/ApplicantService";
import {withRouter} from "react-router-dom";

class UpdateApplicantComponent extends Component {
	constructor(props){
		super(props)

		this.state = {
			id: this.props.match.params.id,
			firstName: this.props.match.params.firstName,
			lastName: this.props.match.params.lastName
		}
		this.changeIdHandler = this.changeIdHandler.bind(this);
		this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
		this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
		this.updateApplicant = this.updateApplicant.bind(this);
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

	componentDidMount() {
		ApplicantService.getApplicantById(this.state.id).then ( (res) => {
			let applicant = res.data;
			this.setState({ id: applicant.id, firstName: applicant.firstName, lastName: applicant.lastName
			});
		});
	}

	updateApplicant = (a) => {
		a.preventDefault();
		let applicant = {id: this.state.id, firstName: this.state.firstName, lastName: this.state.lastName}
		console.log('applicant =>'+JSON.stringify(applicant));
		ApplicantService.updateApplicant(applicant.id, applicant).then(res =>{
			this.props.history.push("/applicants");
		}).catch((error)=>console.log(error.response.data));
	}
	cancel() {
		this.props.history.push('/applicants');
	}
	render()
	{
		return (
				<div>
					<div className="container">
						<div className="row">
							<div className="card col-md-6 offset-md-3 offset-md-3">
								<h3 className="text-center">Update Applicant</h3>
								<div className="card-body">
									<form>
										<div className="form-group">
											<label> Applicant ID: </label>
											<input name="id" className="form-control"
													value={this.state.id} onChange={this.changeIdHandler}/>
										</div>
										<div className="form-group">
											<label> First Name: </label>
											<input  name="firstName" className="form-control"
													value={this.state.firstName} onChange={this.changeFirstNameHandler}/>
										</div>
										<div className="form-group">
											<label> Last Name: </label>
											<input  name="lastName" className="form-control"
													value={this.state.lastName} onChange={this.changeLastNameHandler}/>
										</div>
										<button className="btn btn-success" onClick={this.updateApplicant}>Update</button>
										<button className="btn btn-danger" onClick={this.cancel} style={{marginLeft:"10px"}}>Cancel</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
		);
	}
}

export default withRouter(UpdateApplicantComponent);