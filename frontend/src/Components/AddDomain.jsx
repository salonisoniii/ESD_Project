import {  useState } from "react";
import axios from "axios";
import { useNavigate } from 'react-router-dom';
import {Link} from 'react-router-dom'
import '../CSS/AddDomain.css'
const  AddDomain= () => {
    const navigate = useNavigate();
      const [batch, setBatch] = useState("");
      const [capicity, setCapicity] = useState("");
      const [program, setProgram] = useState("");
      const [qualification, setQualification] = useState("");
      async function addDomain(event) {
          event.preventDefault();
          try {
            await axios.post("http://localhost:8080/create", {
            program: program,
            batch: batch,
            capicity: capicity,
            qualification:qualification,
            });
            alert("Domain Added Successfully");
            navigate("/home");
          } catch (err) {
            alert(err);
          }
      }    
    return ( 
      <div>
        <div class="navbar">
     <h1>Domains</h1>
     <div>
    <Link className="btn btn-outline-success" to="/add-domain">Add Domain</Link>
    <Link className="btn btn-outline-danger" to="/">Logout</Link>
    </div>
    </div>
      <div className="container-2 mt-5">
      <div className="col-md-6 offset-md-3">
        <h2 className="mb-4">Add Program</h2>
        <form>
          <div className="form-group">
            <label htmlFor="program" className="label-class" >Program:</label>
            <input type="text" className="form-control" placeholder="Enter Program Name" id="program" name="program" required value={program}
           onChange={(event) => {
           setProgram(event.target.value);
            }}/>
          </div>
          <div className="form-group">
            <label htmlFor="batch" className="label-class">Batch:</label>
            <input type="text" className="form-control" placeholder="Enter Batch Name" id="batch" name="batch" required value={batch}
            onChange={(event) => {
            setBatch(event.target.value);
            }}/>
          </div>
          <div className="form-group">
            <label htmlFor="capacity" className="label-class">Capacity:</label>
            <input type="number" className="form-control" placeholder="Enter Capicity" id="capacity" name="capacity" required value={capicity}
            onChange={(event) => {
            setCapicity(event.target.value);
            }}/>
          </div>
          <div className="form-group">
            <label htmlFor="qualification"className="label-class">Qualification:</label>
            <input type="text" className="form-control" placeholder="Enter Qualification" id="qualification" name="qualification" required value={qualification}
            onChange={(event) => {
            setQualification(event.target.value);
            }}/>
          </div>
          <button type="submit" className="btn btn-primary custom" onClick={addDomain}>Add</button>
        </form>
      </div>
    </div>
    </div>
     );
}
export default AddDomain;