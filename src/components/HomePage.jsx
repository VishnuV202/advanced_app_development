import React from 'react'
import '../assets/css/HomePage.css'
import { useNavigate } from 'react-router-dom'
import logo from '../assets/images/monkeymartlogo.jpeg'
const HomePage = () => {
  const navigate = useNavigate();
  const handleHomeClick = () => {

    navigate('/homepage')
  }
  return (
    <nav>

      <div className='OuterNav'>
        <div className='HomePageSideBar'>

        </div>
        <div className='logo'>
          <img id='monkeymartlogo' src={logo} alt=''/>

        </div>
        <div className='HomePageTitle'>
          <span>Monkeymart</span>
        </div>
        <div className='NavList'>
          <ul>
            <li><a className="active" href="/homepage" onClick={handleHomeClick}>Home</a></li>
            <li><a href="/aboutpage">About</a></li>
            <li><a href="/contact">Contact</a></li>
          </ul>
        </div>
      </div>
    </nav>
  )
}

export default HomePage