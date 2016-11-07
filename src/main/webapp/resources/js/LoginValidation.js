$(document).ready(function(){
var loginswitch= document.getElementById("usercheckbox");
setTimeout(validateEmails,2000);
setTimeout(validateNames,2000);
setTimeout(checkNameAgainstDatabase,2000);
var LOGIN_NAME_ERROR="User name must not contain special characters.";
var USER_NAME_LENGTH="User name must be between 3 and 8 characters long.";
document.getElementsByClassName("slider")[0].addEventListener("click", function (){
if(loginswitch.checked==false){
addEvent(loginswitch,'click',setTimeout(formValidate,1500));
removeEvent(loginswitch,'click',validateNames);
removeEvent(loginswitch,'click',validateEmails);
removeEvent(loginswitch,'click',checkNameAgainstDatabase);
}else{
removeEvent(loginswitch,'click',formValidate);
addEvent(loginswitch,'click',validateEmails);
addEvent(loginswitch,'click',validateNames);
addEvent(loginswitch,'click',checkNameAgainstDatabase);
}
});

function formValidate(){
console.log(document.getElementById("loginusername"));
if(document.getElementById("loginusername")!=null){
var loginName= document.getElementById("loginusername");     //grab login username field
}
if(document.getElementById("loginpassword")!=null){
var loginPassword=document.getElementById("loginpassword");  //grab password input field
}
if(loginName==null){
console.log("Not reading");
}
if(loginName!=null){
console.log("Entering login form")
addEvent(loginName,'input',validateLoginName);
 addEvent(loginName,'focus',validateLoginName);// bind event handler to input field
}

function validateLoginName(e){
var nameError= document.getElementsByClassName("loginnameerror")[0];
var target = e.target || e.srcElement;
var count = target.value.length;
var exp= new RegExp("^[a-zA-Z0-9]+$");
if((count!=0 && count <3) || (count !=0 && count > 8)){
$(target).css({'border-color':'#f61a1a'});   // change border color to red
$('input[type="submit"]').prop('disabled',true); // disable submit button
$(nameError).css({'display':'block'});
nameError.innerText=USER_NAME_LENGTH;
}else if(count==0){
$(target).css({'border-color':'#fff'});
$('input[type="submit"]').prop('disabled',true);
$(nameError).css({'display':'none'});
}else if(!exp.test($(target).val())){
$(target).css({'border-color':'#f61a1a'});   // change border color to red
$('input[type="submit"]').prop('disabled',true); // disable submit button
$(nameError).css({'display':'block'});
nameError.innerText=LOGIN_NAME_ERROR;
}else{
$(target).css({'border-color':'#22ba22'});
nameError.innerText="";
$(nameError).css({'display':'none'});
$('input[type="submit"]').prop('disabled',false);
}

}
}


});