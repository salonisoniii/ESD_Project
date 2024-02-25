import {  useState } from "react";
import axios from "axios";
import { useNavigate,Link} from 'react-router-dom';
const Registration = () => {
  const navigate = useNavigate();
    const [admin_name, setAdminName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [dept,setDept]=useState("");
    async function register(event) {
        event.preventDefault();
        try {
          await axios.post("http://localhost:8080/register", {
          username: admin_name,
          email: email,
          password: password,
          dept: dept
          });
          alert("Admin Registation Successfully");
          navigate("/home");
        } catch (err) {
          alert(err);
        }
    }    
    return ( 
   <form>
   <div className="mb-3">
    <label htmlFor="exampleInputPassword1" className="form-label">
      Administrator Name
    </label>
    <input
      type="text"
      className="form-control"
      id="admin_name"
      value={admin_name}
      onChange={(event) => {
      setAdminName(event.target.value);
      }}
    />
  </div>          
  <div className="mb-3">
    <label htmlFor="exampleInputEmail1" className="form-label">
      Email address
    </label>
    <input
      type="email"
      className="form-control"
      id="email"
      aria-describedby="emailHelp"
      value={email}
      onChange={(event) => {
      setEmail(event.target.value);
      }}
    />
    <div id="emailHelp" className="form-text">
      We'll never share your email with anyone else.
    </div>
  </div>
  <div className="mb-3">
    <label htmlFor="exampleInputPassword1" className="form-label">
      Password
    </label>
    <input
      type="password"
      className="form-control"
      id="password"
      value={password}
      onChange={(event) => {
      setPassword(event.target.value);
      }}
    />
  </div>
  <div className="mb-3">
    <label htmlFor="exampleInputDepartment" className="form-label">
      Department Name
    </label>
    <input
      type="text"
      className="form-control"
      id="dept"
      value={dept}
      onChange={(event) => {
      setDept(event.target.value);
      }}
    />
  </div>
  <button type="submit" className="btn btn-primary" onClick={register}>
    Submit
  </button>
</form>
);
}
export default Registration;