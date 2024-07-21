// for require check
function require(value){
    if(value=="" || value==null){
        return false;
    }else{
        return true;
    }
}

//for validate email check
function validateEmail(email) {
    var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if(emailPattern.test(email)){
        return true;
    }else{
        return false;
    }
}

function passLength(val,x){
    if(val.length == x){
        return true;
    }else{
        return false;
    }
}

function passFormat(val){
    var passwordPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    if(passwordPattern.test(val)){
        return true;
    }else{
        return false;
    }
}

//for validate phone number check
function phoneFormat(val){
    var phonePattern = /^[0-9]*$/; 
    if(phonePattern.test(val)){
        return true;
    } else{
        return false;
    }
}