<%@page import="java.util.ArrayList"%>
<%@page import="Member_p.Model_p.MemberDTO"%>
<%@page import="Member_p.Model_p.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <form action="LoginReg" method="post">
    	<table border="">
    		<tr>
	    		<td>
	    			개인회원<input type="radio" name="memberkind" value="개인회원"/>
	    			법인회원<input type="radio" name="memberkind" value="법인회원"/>
	    		</td>
    		</tr>
    		<tr>
    			<td>ID</td>
    			<td><input type="text" name="pid"/></td>
    		</tr>
    		<tr>
    			<td>PW</td>
    			<td><input type="password" name="pw" /></td>
    			<td rowspan="2">
				<input type="submit" value="로그인" />
				</td>
    		</tr>
    	</table>
    </form>

    