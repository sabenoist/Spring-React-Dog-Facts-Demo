import React, { useState, useEffect } from "react";
import axios from "axios";

import logo from './logo.svg';
import './App.css';

function App() {
  const [facts, setFacts] = useState([]);

  // Fetch an initial dog fact when loading the page
  useEffect(() => {
    axios.get("http://localhost:8080/api/dog-facts")
      .then(response => setFacts(response.data))
      .catch(error => console.error("Error fetching data:", error));
  }, []);

  // Function to fetch another dog fact
  const fetchAnotherFact = () => {
    axios.get("http://localhost:8080/api/dog-facts")
      .then(response => {
        if (response.data) {
          setFacts(prevFacts => [...prevFacts, response.data]);
        }
      })
      .catch(error => console.error("Error fetching another fact:", error));
  };

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
      </header>
      <div className="Dog-facts-container">
        <ul>
          {facts.map((fact, index) => (
            <li key={index}>{fact}</li>
          ))}
        </ul>
        
        <button className="Fetch-fact-button" onClick={fetchAnotherFact} style={{  }}>
          🐶 Fetch Another Fact 🐶
        </button>
      </div>
    </div>
  );
}

export default App;
