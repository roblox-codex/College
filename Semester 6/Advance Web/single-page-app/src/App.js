import React from 'react';
import StudentInfo from './StudentInfo';
import './App.css'; 

function App() {
    const student = {
        name: 'John Doe',
        age: 16,
        grade: '10th',
        school: 'Springfield High School'
    };

    return (
        <div className="App">
            <StudentInfo student={student} />
        </div>
    );
}

export default App;
