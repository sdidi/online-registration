import axios from "axios";

const  APPLICANT_REGISTRATION_API_BASE_URL = "http://localhost:8080/registrationapi/applicants";
const  APPLICANT_REGISTRATION_API_BASE_URL_ADD = "http://localhost:8080/registrationapi/addapplicant";
const  APPLICANT_REGISTRATION_API_BASE_URL_UPDATE = "http://localhost:8080/registrationapi/editapplicant";
const  APPLICANT_REGISTRATION_API_BASE_URL_DELETE= "http://localhost:8080/registrationapi/deleteapplicant";
class ApplicantService {

	getApplicants(){
		return axios.get(APPLICANT_REGISTRATION_API_BASE_URL);
	}

	addApplicant(applicant){
		return axios.post(APPLICANT_REGISTRATION_API_BASE_URL_ADD ,applicant)
	}

	getApplicantById(id){
		return axios.get(APPLICANT_REGISTRATION_API_BASE_URL + '/' +id);
	}

	updateApplicant(id, applicant){
		return axios.put(APPLICANT_REGISTRATION_API_BASE_URL_UPDATE + '/' +id, applicant);
	}

	deleteApplicant(id){
		return axios.delete(APPLICANT_REGISTRATION_API_BASE_URL_DELETE + '/' +id);
	}

}
export default  new ApplicantService();