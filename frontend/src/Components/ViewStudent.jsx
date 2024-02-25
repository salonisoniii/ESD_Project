import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import '../CSS/ViewStudent.css'
const ViewStudent = () => {
    const [students, setStudents] = useState([]);
    const { id } = useParams();
    useEffect(() => {
        loadStudents();
    }, []);
    const loadStudents = async () => {
        const result = await axios.get(
          `http://localhost:8080/view_student/${id}`
        );
        setStudents(result.data);
        console.log(result);
    };
    return (
      <><Link className="btn btn-outline-danger" to="/">Logout</Link>      <div className="container-fluid">
      <div className="row row-cols-1 row-cols-md-4 g-4" style={{overflowY: "scroll", height: "100vh"}}>
      {students.map((student) => (
        <div className="col" key={student.id} >
          <div className="card h-100 d-flex flex-column">
            <img src={student.photograph_path}className="card-img-top" alt="" />
            <div className="card-body">
              <h5 className="card-title">Student Details</h5>
              <p className="card-text">
                <h6>STUDENT ID: {student.id}</h6>
                <h6>FIRST NAME: {student.first_name}</h6>
                <h6>LAST NAME: {student.last_name}</h6>
                <h6>EMAIL ID: {student.email}</h6>
                <h6>GRAD YEAR: {student.graduation_year}</h6>
              </p>
            </div>
          </div>
        </div>
      ))}
    </div>
    </div>
    </>      
    );    
}
 
export default ViewStudent;
