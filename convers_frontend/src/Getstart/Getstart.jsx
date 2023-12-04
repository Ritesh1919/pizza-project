import React from "react";
import { useState } from "react";
import axios from 'axios'

export default function GetStart() {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
    // confirmPassword: '',
    address: '',
  });

  const handleSignIn = async () => {
    try {
      const response = await axios.post('http://localhost:2000/signUp',
        JSON.stringify(formData), {
          headers: {
            "Content-Type": "application/json"
          }
      }
      );

      // Handle successful sign-in (e.g., set user authentication token)
      console.log('Sign-in successful:', response.data);
      alert("register successful");
    } catch (error) {
      // Handle sign-in error
      console.error('Sign-in failed:', error.message);
      alert("user already exist");
    }
  };


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

    // Validate password and confirm password
    // if (formData.password !== formData.confirmPassword) {
    //   alert('Passwords do not match. Please try again.');
    //   return;
    // }

    // You can perform registration logic here using the formData
    console.log('Registration data:', formData);
  };

  return (
    <div className="flex items-center justify-center h-screen ">
      <div className="bg-white p-8 rounded shadow-md text-center w-1/2">
        <h2 className="text-2xl font-semibold mb-6">Registration</h2>
        <form onSubmit={handleSubmit} className="text-left">
          <div className="mb-4">
            <label className="block text-sm font-semibold mb-2">Username:</label>
            <input
              type="text"
              name="name"
              value={formData.name}
              onChange={handleInputChange}
              required
              className="w-full px-3 py-2 border rounded"
            />
          </div>
          <div className="mb-4">
            <label className="block text-sm font-semibold mb-2">Email:</label>
            <input
              type="email"
              name="email"
              value={formData.email}
              onChange={handleInputChange}
              required
              className="w-full px-3 py-2 border rounded"
            />
          </div>
          <div className="mb-4">
            <label className="block text-sm font-semibold mb-2">Address:</label>
            <input
              type="text"
              name="address"
              value={formData.address}
              onChange={handleInputChange}
              required
              className="w-full px-3 py-2 border rounded"
            />
          </div>
          <div className="mb-4">
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
          {/* <div className="mb-6">
            <label className="block text-sm font-semibold mb-2">Confirm Password:</label>
            <input
              type="password"
              name="confirmPassword"
              value={formData.confirmPassword}
              onChange={handleInputChange}
              required
              className="w-full px-3 py-2 border rounded"
            />
          </div> */}
          <button type="submit" className="bg-green-500 text-white px-4 py-2 rounded hover:bg-green-600 text-center" onClick={handleSignIn}>
            Register
          </button>
        </form>
      </div>
    </div>
  );
};

