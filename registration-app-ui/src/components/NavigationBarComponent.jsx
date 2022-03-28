import React, {Component} from 'react';
import {Navbar, Nav} from "react-bootstrap";
import {Link} from 'react-router-dom';

class NavigationBarComponent extends Component {
	render()
	{
		return (
				<Navbar bg="dark" variant="dark">
					<Nav className="mt-auto">
						<Link to={"/applicants"} className="nav-link">List of Applicants</Link>
						<Link to={"/addapplicant"} className="nav-link">Add Applicant</Link>
					</Nav>
				</Navbar>

		);
	}
}

export default NavigationBarComponent;