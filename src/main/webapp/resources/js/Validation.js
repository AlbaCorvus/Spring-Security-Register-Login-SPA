
var validateNames=function(){
var username =document.getElementById('registerusername');   // get register form username input area
var nameError= document.getElementsByClassName("registernameerror")[0];
var ERROR_LENGTH="Please input user name between 3 and 8 characters in length.";
var ERROR_SYNTAX="User name can only contain letters and numbers a-z 0-9.";
var ERROR_NAME_TAKEN="Name already exists please choose a different name";
var exp = new RegExp('^[a-zA-Z0-9]+$');

// addEvent can be found in Utilities.js
console.log("username" + username);
addEvent(username,'focus',validateName);  //Call validate on focus
addEvent(username,'input',validateName);  // Call validate on input to username


function validateName(e){
var target = e.target || e.srcElement;  // Get target to event
var count =target.value.length;   // find amount of characters input

if((count!=0 && count < 3) || (count!=0 && count >8)){ // if input less than 3 greater then 8 change output
$('input[type="text"]').css({'border-color':'#fff'}); // change all inputs border color to white purely cosmetic
$(target).css({'border-color':'#f61a1a'}); // change border color
nameError.innerText=ERROR_LENGTH; // set error message to pre-defined string
$(nameError).css({'display':'block'});
$('input[type="submit"]').prop('disabled',true);  // disabled submit button on form
}else if(!exp.test(target.value) && count!=0){ // validate input against regular expression for special characters
$('input[type="submit"]').css({'border-color':'#fff'});
$(target).css({'border-color':'#f61a1a'});
nameError.innerText=ERROR_SYNTAX;
$('input[type="submit"]').prop('disabled',true); // disable submit button on form
$(nameError).css({'display':'block'});
}else if(count==0){
nameError.innerText="";
$(nameError).css({'display':'none'});
$(target).css({'border-color':'#fff'});
$('input[type="submit"]').prop('disabled',true); // disable submit option
}else if(AjaxSaysNo){
 $(target).css({'border-color':'red'});
          nameError.innerText=ERROR_NAME_TAKEN; // set error message to pre-defined string
          $(nameError).css({'display':'block'});
          $('input[type="submit"]').prop('disabled',true);
}else{
$('input[type="text"]').css({'border-color':'#fff'});
$(target).css({'border-color':"#22ba22"});
$(nameError).css({'display':'none'});
nameError.innerText="";
$('input[type="submit"]').prop('disabled',false);  // allow submission of form
}

// call ajax after xss script detection for match existing in database


}


}


var validateEmails= function(){
var email=document.getElementById('registeremail');  // get email input field
var emailError = document.getElementsByClassName('registeremailerror')[0]; // grabs the first element in the array of elements by class name
var ERROR_EMAIL="Incorrect structure for email.";
var exp=new RegExp("^(?=.*[@])[a-zA-Z0-9@.]+$");

console.log("email"+ email);
addEvent(email,'focus',validateEmail); // attach event listener to element
addEvent(email,'input',validateEmail);

function validateEmail(e){
var target = e.target || e.srcElement;
var validEmail=exp.test($(target).val()); // generate validEmail boolean against regular expression
if(validEmail){ // enter boolean in conditional if() statement
emailError.innerText="";
$(emailError).css({'display':'none'});
$(target).css({'border-color':'#22ba22'});
$('input[type="submit"]').prop('disabled',false); // disable submit option
}else if($(target).val()==""){
emailError.innerText="";
$(emailError).css({'display':'none'});
$(target).css({'border-color':'#fff'});
$('input[type="submit"]').prop('disabled',true); // disable submit option
}else{
$(target).css({'border-color':'#f61a1a'});
$(emailError).css({'display':'block'});
emailError.innerText=ERROR_EMAIL;
$('input[type="submit"]').prop('disabled',true); // enable submit
}
}



}

