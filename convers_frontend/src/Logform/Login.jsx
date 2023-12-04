import axios from "axios";
import React from "react";
import  { useState } from 'react';
import { useNavigate } from "react-router-dom";




const Login = () => {
  // State for storing user input
  const [formData, setFormData] = useState({
    email: '',
    password: '',
  });
 
const navigate =useNavigate();
  // Function to handle input changes
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };
  // Function to handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();
    // You can perform login logic here using the formData
    console.log('Form submitted with data:', formData);
  };



  const Submitbutton = async () => {
  
    try {
      const response = await axios.post('http://localhost:2000/login', 
       JSON.stringify(formData),{headers:{
        "Content-Type": "application/json"
       }}
      );

      // Handle successful sign-in (e.g., set user authentication token)
      console.log('Sign-in successful:', response.data);
      if(response.data){
       navigate('/Order');
      }
      
    } catch (error) {
      // Handle sign-in error
      console.error('Sign-in failed:', error.message);
    }
  };


  return (
    <div className="flex items-center justify-center h-screen">
      <div className="bg-white p-8 rounded shadow-md text-center w-1/2">
        <h2 className="text-2xl font-semibold mb-6">Login</h2>
        <form onSubmit={handleSubmit} className="text-left">
          <div className="mb-4">
            <label className="block text-sm font-semibold mb-2">Email:</label>
            <input
              type="text"
              name="email"
              value={formData.email}
              onChange={handleInputChange}
              required
              className="w-full px-3 py-2 border rounded"
            />
          </div>
          <div className="mb-6">
            <label className="block text-sm font-semibold mb-2">Password:</label>
            <input
              type="password"
              name="password"
              value={formData.password}
              onChange={handleInputChange}
              required
              className="w-full px-3 py-2 border rounded"
            />
          </div>
          <button type="submit" className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600" onClick={Submitbutton}>
            Login
          </button>
        </form>
      </div>
    </div>
  );
};

export default Login;
