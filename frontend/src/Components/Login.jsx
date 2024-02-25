import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { Link } from "react-router-dom";
import '../CSS/Login.css'
const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();
  async function login(event) {
    event.preventDefault();
    try {
      await axios
        .post("http://localhost:8080/login", {
          email: email,
          password: password,
        })
        .then(
          (res) => {
            console.log(res.data);

            if (res.data.message === "Email not exits") {
              alert("Email not exits");
            } else if
              (res.data.message=="not allowed to login"){
                alert("Only Admins Are Allowed To Login");
              }
             else if (res.data.message === "Login Success") {
              navigate("/home");
            } else {
              alert("Incorrect Email and Password not match");
            }
          },
          (fail) => {
            console.error(fail); // Error!
          }
        );
    } catch (err) {
      alert(err);
    }
  }
  return (
    <form className="formtop">
      <div class="logo-container">
      {/* <img src="/logo512.png" alt="Logo" class="logo"/> */}
     </div>
      <div className="mb-3">
        <label htmlFor="exampleInputEmail1" className="form-label">
          Email address
        </label>
        <input
          type="email"
          className="form-control"
          id="email"
          autoComplete="off"
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
          autoComplete="off"
          value={password}
          onChange={(event) => {
            setPassword(event.target.value);
          }}
        />
      </div>
      <button type="submit" className="btn btn-primary" onClick={login}>
        Submit
      </button>
      <div>
        <p class="mt-3">
          Not registered?   <Link to="/register">Register Here</Link>
        </p>
      </div>
    </form>
  );
};
export default Login;
