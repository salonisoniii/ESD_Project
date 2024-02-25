import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Link, useNavigate, useParams } from 'react-router-dom';
import '../CSS/ModifyDomain.css'
export default function ModifyDomain() {
    let navigate = useNavigate()
    const {id} = useParams()
    console.log('ID:', id);
    const [domain,setDomain] = useState({
        program:"",
        batch:"",
        capicity:"",
        qualification:""
    })
    const{program,batch,capicity,qualification} = domain

    const onInputChange=(e)=>{
        setDomain({...domain,[e.target.name]:e.target.value});
    }
    
    useEffect(()=>{
        loadDomain()
    },[])

    const onSubmit=async(e)=>{
        e.preventDefault();
        await axios.put(`http://localhost:8080/update/${id}`,domain)
        alert("updated successfully..");
        navigate("/home");
    }

    const loadDomain = async () =>{
        const result= await axios.get(`http://localhost:8080/view/${id}`)
        setDomain(result.data)
    }

  return (
    <div>
    <div class="navbar-m">
     <div>
    <Link className="btn btn-outline-success" to="/add-domain">Add Domain</Link>
    <Link className="btn btn-outline-danger mx-5" to="/">Logout</Link>
    </div>
    </div>
    <div className='container-mod col-md-6 offset-md-3'>
        <div className='row'>
            <div>
                <h2 className='text-center m-4 modifyh2'>Edit Domain</h2>
                <form class="forml" onSubmit={(e)=>onSubmit(e)}>
                <div className='mb-3'>
                        <label htmlFor='Name' className='form-label'>
                            Program
                        </label>
                        <input
                            type={"text"}
                            className="form-control-2"
                            placeholder='Enter Program'
                            name="program"
                            value={program}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>
                    <div className='mb-3'>
                        <label htmlFor='Name' className='form-label'>
                            Batch
                        </label>
                        <input
                            type={"text"}
                            className="form-control-2"
                            placeholder='Enter the Batch'
                            name="batch"
                            value={batch}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>
                    <div className='mb-3'>
                        <label htmlFor='Name' className='form-label'>
                            Capacity
                        </label>
                        <input
                            type={"text"}
                            className="form-control-2"
                            placeholder='Enter the capacity'
                            name="capicity"
                            value={capicity}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>
                    <div className='mb-3'>
                        <label htmlFor='Name' className='form-label'>
                            Qualification
                        </label>
                        <input
                            type={"text"}
                            className="form-control-2"
                            placeholder='Enter the qualification required'
                            name="qualification"
                            value={qualification}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>
                    <button type='submit' className='btn btn-outline-primary'>Submit</button>
                    <Link  className='btn btn-outline-danger mx-3' to='/home'>Cancel</Link>
                </form>
            </div>
        </div>
    </div>
    </div>
  )
};