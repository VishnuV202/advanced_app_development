import React, { useState } from 'react'
// import '../assets/css/RegisterPage.css';
import { useNavigate } from 'react-router-dom';
import { postData } from '../API';
const RegisterPage = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [email, setEmail] = useState('');
  const navigate = useNavigate();

  const onHandleClick = () => {
    navigate('/');
  }
  const handleSubmit = (e) => {
    if (username === '' && email === '' && password === '') {
      alert("Please enter your details for signing up.");
    }
    else {
      if (username === '') {
        alert("Please enter username");
        e.preventDefault();
      }
      else if (email === '') {
        alert("Please enter email");
        e.preventDefault();
      }
      else if (password === '') {
        alert("please enter password");
        e.preventDefault();
      }
      else {
        if (password !== confirmPassword) {
          alert("The confirmed password should be same as the entered password. Please re confirm");
        }
        else {
          postData(username, email, password);
          alert("Signup is complete ! Please login now");
          navigate('/');
        }
      }
    }
  }
  return (
    <div className="containerSignup">
      <div className="form-controlSignUp">
        <form onSubmit={handleSubmit}>
          <h2>SIGN UP</h2>
          <label>Enter a Username:</label>
          <input
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
          <label>Enter your email:</label>
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <label>Set a Password:</label>
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <label>Confirm your Password:</label>
          <input
            type="password"
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
          />
          <button type="submit">Signup</button>
          <button type="submit" onClick={onHandleClick}>Login</button>
        </form>
      </div>
    </div>
  )
}

export default RegisterPage;