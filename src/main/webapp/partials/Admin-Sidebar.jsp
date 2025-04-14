<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="sidebar">
    <ul class="sidebar--items">
        <li><a href="index.html" class="active"><span class="icon"><i class="ri-user-fill"></i></span><div class="sidebar--item">Profile</div></a></li>
        <li><a href="attendence.html"><span class="icon"><i class="ri-calendar-line"></i></span><div class="sidebar--item">Attendence</div></a></li>
        <li><a href="<%= request.getContextPath() %>/Student-Details.jsp"><span class="icon"><i class="ri-user-line"></i></span><div class="sidebar--item">Student list</div></a></li>
        <li><a href="staffinfo.html"><span class="icon"><i class="ri-user-2-fill"></i></span><div class="sidebar--item">Staff members</div></a></li>
        <li><a href="payment.html"><span class="icon"><i class="ri-bank-card-line"></i></span><div class="sidebar--item">Payment</div></a></li>
        <li><a href="feedback.html"><span class="icon"><i class="ri-feedback-line"></i></span><div class="sidebar--item">Feedback</div></a></li>
        <li><a href="sucesstory.html"><span class="icon"><i class="ri-trophy-line"></i></span><div class="sidebar--item">Success Story</div></a></li>
        <li><a href="leaveform.html"><span class="icon"><i class="ri-survey-line"></i></span><div class="sidebar--item">Leave Form</div></a></li>
        <li><a href="alert.html"><span class="icon"><i class="ri-spam-line"></i></span><div class="sidebar--item">Alert & Fine</div></a></li>
    </ul>
    <ul class="sidebar--bottom--items">
        <li><a href="#"><span class="icon"><i class="ri-logout-box-r-line"></i></span><div class="sidebar--item">Logout</div></a></li>
    </ul>
</div>