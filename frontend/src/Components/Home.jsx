import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import '../CSS/Home.css'

export default function Home() {
  const [domains, setDomains] = useState([]);

  useEffect(() => {
    loadDomains();
  }, []);

  const loadDomains = async () => {
    const result = await axios.get(
      "http://localhost:8080/view"
    );
    setDomains(result.data);
    console.log(result.data);
  };
  
  return (
    <div className="container">
     <div class="navbar">
     <h1>Domains</h1>
     <div>
    <Link className="btn btn-outline-success" to="/add-domain">Add Domain</Link>
    <Link className="btn btn-outline-danger" to="/">Logout</Link>
    </div>
    </div>

      <div className="py-4">
        <table className="table shadow table-hover table-striped table-c">
          <thead>
            <tr>
              <th scope="col">Domain_ID</th>
              <th scope="col">Program</th>
              <th scope="col">Batch</th>
              <th scope="col">Capactiy</th>
              <th scope="col">Qualification</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            {domains.map((domain, index) => (
              <tr key={domain.id}>
                <td class="tdc">{domain.id}</td>
                <td>{domain.program}</td>
                <td>{domain.batch}</td>
                <td>{domain.capicity}</td>
                <td>{domain.qualification}</td>
                <td>
                  <Link
                    className="btn btn-primary mx-2"
                    to={`/Students/${domain.id}`}
                  >
                    View Students
                  </Link>
                  <Link
                    className="btn btn-warning mx-2"
                    to={`/modify-domain/${domain.id}`}
                  >
                    Edit Domain
                  </Link>
                </td>
              </tr>
            ))}
          </tbody>
        </table>      
      </div>
    </div>
  );
}