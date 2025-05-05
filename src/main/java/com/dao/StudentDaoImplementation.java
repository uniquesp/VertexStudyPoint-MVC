package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.model.LeaveFormDTO;
import com.model.StudentDTO;
import com.util.DbConnection;

public class StudentDaoImplementation implements StudentDao {

	@Override
	public boolean registerOrUpdateStudent(StudentDTO studentDTO) {
	    PreparedStatement preparedStatement = null;
	    Connection connection = null;

	    String INSERT_STUDENT_SQL = "INSERT INTO student (student_first_name, student_last_name, student_email, student_mobileno, student_gender, student_birthdate, student_address, study, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    String UPDATE_STUDENT_SQL = "UPDATE student SET student_first_name = ?, student_last_name = ?, student_email = ?, student_mobileno = ?, student_gender = ?, student_birthdate = ?, student_address = ?, study = ?, password = ? WHERE student_id = ?";

	    boolean studentInserted = false;
	    boolean studentUpdated = false;

	    try {
	        connection = DbConnection.createConnection();

	        if (studentDTO.getStudentId() != 0) {
	            // Update existing student
	            preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL);
	        } else {
	            // Insert new student
	            preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL);
	        }

	        // Common parameter bindings
	        preparedStatement.setString(1, studentDTO.getFirstName());
	        preparedStatement.setString(2, studentDTO.getLastName());
	        preparedStatement.setString(3, studentDTO.getEmailId());
	        preparedStatement.setString(4, studentDTO.getContactNo());
	        preparedStatement.setString(5, studentDTO.getGender());
	        preparedStatement.setDate(6, (Date) studentDTO.getDob());
	        preparedStatement.setString(7, studentDTO.getAddress());
	        preparedStatement.setString(8, studentDTO.getStudy());
	        preparedStatement.setString(9, studentDTO.getPassword());

	        if (studentDTO.getStudentId() != 0) {
	            // Add id for WHERE clause in update
	            preparedStatement.setInt(10, studentDTO.getStudentId());
	            studentUpdated = preparedStatement.executeUpdate() > 0;
	        } else {
	            studentInserted = preparedStatement.executeUpdate() > 0;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return studentInserted || studentUpdated;
	}

	@Override
	public JsonObject loginStudent(StudentDTO studentdto) {
		JsonObject jsonObject = new JsonObject();
		String FIND_USER = "SELECT student_id,student_first_name, student_last_name FROM student WHERE is_deleted=0 AND student_email=? AND password=?";
		try {
			Connection connection = DbConnection.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER);
			jsonObject.addProperty("userId", 0);
			preparedStatement.setString(1, studentdto.getEmailId());
			preparedStatement.setString(2, studentdto.getPassword());
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				jsonObject.addProperty("studid", result.getInt("id"));
				jsonObject.addProperty("studfname", result.getString("student_first_name"));
				jsonObject.addProperty("studlname", result.getString("student_last_name"));
			}
			result.close();
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

//	Admin dashboard methodes 
	@Override
	public List<StudentDTO> getAllUsers(StudentDTO studentdto) {
		List<StudentDTO> studentList = new ArrayList<>();
		ResultSet resultSet = null;
		String SELECT_ALL_USERS_SQL = "SELECT * FROM student WHERE is_deleted=0";
		String SELECT_ONE_USER_SQL = "SELECT * FROM student WHERE is_deleted=0 AND student_id=?";
		try {
			Connection connection = DbConnection.createConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			if (studentdto.getStudentId() != 0) {
				preparedStatement = connection.prepareStatement(SELECT_ONE_USER_SQL);
				preparedStatement.setInt(1, studentdto.getStudentId());
				resultSet = preparedStatement.executeQuery();
			} else {
				resultSet = statement.executeQuery(SELECT_ALL_USERS_SQL);
			}
			while (resultSet.next()) {
				StudentDTO StudentDTO2 = new StudentDTO();
				StudentDTO2.setStudentId(Integer.parseInt(resultSet.getString("student_id")));
				StudentDTO2.setFirstName(resultSet.getString("student_first_name"));
				StudentDTO2.setLastName(resultSet.getString("student_last_name"));
				StudentDTO2.setEmailId(resultSet.getString("student_email"));
				StudentDTO2.setContactNo(resultSet.getString("student_mobileno"));
				StudentDTO2.setGender(resultSet.getString("student_gender"));
				StudentDTO2.setDob(resultSet.getDate("student_birthdate"));
				StudentDTO2.setAddress(resultSet.getString("student_address"));
				StudentDTO2.setStudy(resultSet.getString("study"));
				studentList.add(StudentDTO2);
			}
			statement.close();
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return studentList;
	}

	@Override
	public boolean deleteStudent(int studentId) {
		boolean deleteStudent = false;
		Connection connection = DbConnection.createConnection();
		String DELETE_STUDENT_SQl = "UPDATE student SET is_deleted=1 WHERE student_id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQl);
			preparedStatement.setInt(1, studentId);
			deleteStudent = preparedStatement.executeUpdate() > 0;
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return deleteStudent;
	}

	@Override
	public List<StudentDTO> getAllFeedbacks(StudentDTO studentdto) {
		List<StudentDTO> feedbackList = new ArrayList<>();
		ResultSet resultSet = null;
		String SELECT_ALL_USERS_SQL = "SELECT \r\n" + "  feedback.feedback_id,\r\n"
				+ "  feedback.feedback_description,\r\n" + "  feedback.rating,\r\n" + "  student.student_id, \r\n"
				+ "  student.student_first_name, \r\n" + "  student.student_last_name, \r\n"
				+ "  student.student_email\r\n" + "FROM \r\n" + "  feedback\r\n" + "JOIN \r\n"
				+ "  student ON feedback.student_id = student.student_id";
		try {
			Connection connection = DbConnection.createConnection();
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(SELECT_ALL_USERS_SQL);

			while (resultSet.next()) {
				StudentDTO StudentDTO2 = new StudentDTO();
				StudentDTO2.setStudentId(Integer.parseInt(resultSet.getString("student_id")));
				StudentDTO2.setFirstName(resultSet.getString("student_first_name"));
				StudentDTO2.setLastName(resultSet.getString("student_last_name"));
				StudentDTO2.setEmailId(resultSet.getString("student_email"));
				StudentDTO2.setContactNo(resultSet.getString("student_mobileno"));
				StudentDTO2.setFeedback_id(Integer.parseInt(resultSet.getString("feedback_id")));
				StudentDTO2.setFeedback_description(resultSet.getString("feedback_description"));
				StudentDTO2.setFeedback_rating(Integer.parseInt(resultSet.getString("rating")));
				feedbackList.add(StudentDTO2);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return feedbackList;
	}

	@Override
	public List<LeaveFormDTO> getAllLeaveDetails(LeaveFormDTO leavedto) {
		List<LeaveFormDTO> leaveDetailsList = new ArrayList<>();
		ResultSet resultSet = null;
		String SELECT_ALL_USERS_SQL = "SELECT \r\n" + "    reading_hall.hall_type,\r\n"
				+ "    student.student_first_name,\r\n" + "    student.student_last_name,\r\n"
				+ "    student.student_email,\r\n" + "    leavedetails.seat_no,\r\n" + "    leavedetails.leave_date\r\n"
				+ "FROM \r\n" + "    leavedetails\r\n" + "JOIN \r\n"
				+ "    reading_hall ON leavedetails.hall_id = reading_hall.hall_id\r\n" + "JOIN \r\n"
				+ "		student ON leavedetails.student_id = student.student_id;\r\n";
		try {
			Connection connection = DbConnection.createConnection();
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(SELECT_ALL_USERS_SQL);

			while (resultSet.next()) {
				LeaveFormDTO leaveFormDTO = new LeaveFormDTO();

				// Create and set StudentDTO
				StudentDTO studentDTO = new StudentDTO();
				studentDTO.setFirstName(resultSet.getString("student_first_name"));
				studentDTO.setLastName(resultSet.getString("student_last_name"));
				studentDTO.setEmailId(resultSet.getString("student_email"));
				studentDTO.setHallType(resultSet.getString("hall_type"));
				studentDTO.setSeatNo(resultSet.getString("seat_no"));

				// Set student inside LeaveFormDTO
				leaveFormDTO.setStudentdto(studentDTO);

				// Set leave date separately (if LeaveFormDTO also stores leaveDate)
				leaveFormDTO.setLibrary_leave_id((resultSet.getInt("leave_id")));
				leaveFormDTO.setLibrary_leave_date(resultSet.getDate("leave_date"));

				leaveDetailsList.add(leaveFormDTO);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return leaveDetailsList;

	}

}
