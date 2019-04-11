/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var queryString = window.location.search;

if (queryString === "?InvalidInput")
{
    document.getElementById("errorMessage").innerHTML = "<center><font color='red'> Invalid Username or Password </font></center>";
}

