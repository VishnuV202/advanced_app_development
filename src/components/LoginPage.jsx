import React, { useEffect, useState } from "react";
import '../assets/css/LoginPage.css';
import { useNavigate } from "react-router-dom";
import { getData } from "../API";
import HomePage from "./HomePage";
const LoginPage = () => {

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [data, setData] = useState([]);

  useEffect(() => {

    const fetch = async () => {
      const response = await getData();
      setData(response.data);
      console.log(data, response.data);
    }
    fetch();
  }, []);

  const navigate = useNavigate();

  const onHandleClick = () => {
    navigate('/register')
  }

  const handleSubmit = (e) => {

    e.preventDefault();
    if (username === "") {
      alert('Please enter Username');
      return;
    }
    else if (password === "") {
      alert('Please enter Password');
      return;
    }
    const uindex = data ? data.findIndex(({ uname }) => uname === username) : -1;
    if (uindex === -1) {
      alert('Invalid Username');
    }
    else if (data[uindex].password !== password) {
      alert('Invalid Password');
    }
    else {
      alert('Login successful');
      navigate('/homepage')
    }
  }

  return (
    <>
    <HomePage/>
      <div className="loginBody">
        <div className="loginImage">
        </div>
        <div className="containerlogin">
          <div className="form-control">
            <form onSubmit={handleSubmit}>
              <h2>Log In</h2>
              <label>Username:</label>
              <input
                type="text"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
              />
              <label>Password:</label>
              <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />

              <button type="submit">Login</button>
              <p id = "ac"> Don't have an account ?</p>
              <button type="submit" onClick={onHandleClick}>Signup</button>
            </form>
          </div>
        </div>
      </div>
    </>
  );
};
export default LoginPage;
