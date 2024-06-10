import React from 'react';
import './StudentInfo.css'; 

const StudentInfo = ({ student }) => {
    return (
        <div className="student-info">
            <h1>Student Information</h1>
            <p><strong>Name:</strong> {student.name}</p>
            <p><strong>Age:</strong> {student.age}</p>
            <p><strong>Grade:</strong> {student.grade}</p>
            <p><strong>School:</strong> {student.school}</p>
        </div>
    );
};

export default StudentInfo;
