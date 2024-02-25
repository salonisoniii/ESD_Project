import {BrowserRouter,Route,Routes} from "react-router-dom";
import Registration from "./Components/Registration";
import Login from "./Components/Login";
import Home from "./Components/Home";
import AddDomain from "./Components/AddDomain";
import ModifyDomain from "./Components/ModifyDomain"
import ViewStudent from "./Components/ViewStudent";
function App() {
  return (
    <div>
    <BrowserRouter>
          <Routes>
            <Route path="/home" element= { <Home/>} />
            <Route path="/register" element= {<Registration/>}/>
            <Route path="/" element= { <Login/>} />
            <Route path="/add-domain" element={<AddDomain/>}/>
            <Route path="/modify-domain/:id" element={<ModifyDomain/>}/>
            <Route path="/Students/:id" element={<ViewStudent/>}/>
          </Routes>
      </BrowserRouter>
    
  </div>
  );
}

export default App;
