const forms = document.querySelector(".forms"),
pwShowHide = document.querySelectorAll(".registration-icon-1.eye-icon"),
pwShowHideConfirm = document.querySelectorAll(".registration-icon-2.eye-icon"),
links = document.querySelectorAll(".link");

pwShowHide.forEach(eyeIcon => {
eyeIcon.addEventListener("click", () => {
  let pwFields = eyeIcon.parentElement.parentElement.querySelectorAll(".password");
  
  pwFields.forEach(password => {
      if(password.type === "password"){
          password.type = "text";
          eyeIcon.classList.replace("bx-hide", "bx-show");
          return;
      }
      password.type = "password";
      eyeIcon.classList.replace("bx-show", "bx-hide");
  })
})
})

pwShowHideConfirm.forEach(eyeIcon => {
  eyeIcon.addEventListener("click", () => {
    let pwFields = eyeIcon.parentElement.parentElement.querySelectorAll(".confirmPassword");
    
    pwFields.forEach(password => {
        if(password.type === "password"){
            password.type = "text";
            eyeIcon.classList.replace("bx-hide", "bx-show");
            return;
        }
        password.type = "password";
        eyeIcon.classList.replace("bx-show", "bx-hide");
    })
  })
  })