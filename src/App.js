import React from 'react';
import { Route, Routes } from 'react-router-dom';
import LoginPage from './components/LoginPage.jsx';
import RegisterPage from './components/RegisterPage';
import HomePage from './components/HomePage.jsx';
import AboutPage from './components/AboutPage.jsx';
function App() {
  return (
      <Routes>
        <Route path="/" exact element={<LoginPage/>}></Route>
        <Route path="/register" element={<RegisterPage/>}></Route>
        <Route path="/homepage" element={<HomePage/>}></Route>
        <Route path="/aboutpage" element={<AboutPage/>}></Route>
      </Routes>
  );
}

export default App;
