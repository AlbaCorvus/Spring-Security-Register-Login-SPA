
var AjaxSaysNo=false;
var ERROR_NAME_TAKEN="Name already exists please choose a different name";
function checkNameAgainstDatabase(){

var nameInput = document.getElementById("registerusername");
var nameError= document.getElementsByClassName("registernameerror")[0];



addEvent(nameInput,'input',checkName);


function checkName(e){

var target = e.getTarget || e.srcElement;

var nameSoFar= target.value;
if(target.value.length>0){
$.ajax({type:"GET",
        url:"/RecruitmentSpring/recruitment/checkName/"+target.value,
        success:function(data){
        console.log(data);
        AjaxSaysNo=data;
        if(!data){
          $(target).css({'border-color':'red'});
          nameError.innerText=ERROR_NAME_TAKEN; // set error message to pre-defined string
          $(nameError).css({'display':'block'});
          $('input[type="submit"]').prop('disabled',true);
        }
        }
        });

}
}

}