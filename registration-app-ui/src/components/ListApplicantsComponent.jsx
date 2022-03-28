import React, {Component} from 'react';
import axios from "axios";
import ApplicantService from "../services/ApplicantService";
import {withRouter} from "react-router-dom";


class ListApplicantsComponent extends Component {
	constructor(props)
	{
		super(props)

		this.state = {
			applicants: [],
			isComponentVisible: false
		}
		this.editApplicant= this.editApplicant.bind(this);
	}

	deleteApplicant(id){
		console.log('Parameters sent => id : '+ id);
		axios.delete("http://localhost:8080/registrationapi/deleteapplicant/"+id)
				.catch((error)=>console.log(error.response.data));
		window.location.reload();
	}

	editApplicant(id){
		this.props.history.push('/editapplicant/'+id);
	}
	componentDidMount() {
		ApplicantService.getApplicants().then((res) => {
			this.setState({applicants: res.data});
		});
	}

	render()
	{
		return (
				<div>
					<h2 className="text-center"> Applicants List	</h2>
					<div className="row">
					</div>
					<div className="row">
						<table className="table table-striped table-bordered">
							<thead>
							<tr>
								<th> Applicant ID </th>
								<th> First Name </th>
								<th> Last Name </th>
								<th>Actions</th>
							</tr>
							</thead>
							<tbody>
							{
								this.state.applicants.map(
										applicant =>
												<tr key = { applicant.id}>
													<td> {applicant.id} </td>
													<td> {applicant.firstName} </td>
													<td> {applicant.lastName} </td>
													<td>
														<button onClick= { () => this.editApplicant(applicant.id)}
																className="btn btn-info">Update</button>

														<button style={{marginLeft:"10px"}} onClick= { () => this.deleteApplicant(applicant.id)}
																className="btn btn-danger">Delete</button>
													</td>
												</tr>
								)
							}
							</tbody>
						</table>
					</div>
				</div>
		);
	}
}

export default withRouter(ListApplicantsComponent);