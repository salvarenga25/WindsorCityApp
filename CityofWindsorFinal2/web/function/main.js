const config = {apiKey: "AIzaSyBrN7Z9IRoROOdmSLq6OAsJHTsOrfiSQJ8",
authDomain: "cow-web-base-app---front-end.firebaseapp.com",
databaseURL: "https://cow-web-base-app---front-end.firebaseio.com",
projectId: "cow-web-base-app---front-end",
storageBucket: "cow-web-base-app---front-end.appspot.com",
messagingSenderId: "628866277069",
appId: "1:628866277069:web:8b5da5b1d02807e6219384"}

firebase.initializeApp(config);

const firestore = firebase.firestore();

const createForm = document.querySelector("#createFrom");
const progressBar = document.querySelector("#progressBar");
const progressHandler = document.querySelector("#progressHandler");
const postSubmit = document.querySelector("#postSubmit");
const openNav = document.querySelector("#openNav");
const closeNav = document.querySelector("#closeNav");



if(createForm!= null){
    let d;
    createForm.addEventListener("submit", async(e)=>{
        e.preventDefault();
        
        if(document.getElementById("title").value != "" && document.getElementById("content").value != "" && document.getElementById("cover").files[0] != "") {

            let title = document.getElementById("title").value;
            let content = document.getElementById("content").value;
            let cover = document.getElementById("cover").files[0];

            console.log(cover);

            const storageRef = firebase.storage().ref();
            const storageChild = storageRef.child(cover.name); //require file name

            console.log("Uploading file...");
            const postCover = storageChild.put(cover); //passes the actual file

            await new Promise((resolve) => {        // resolve being manged by the promise
                postCover.on("state_changed", (snapshot) => {

                    let progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
                    console.log(Math.trunc(progress));


                    if(progressHandler != null){                    //action to be performed
                        progressHandler.style.display = true;
                    }
                    
                    if(postSubmit != null){
                        postSubmit.disabled = true;
                    }

                    if(progressBar != null){
                        progressBar.value = progress; 
                    }   

                }, (error) =>  {            //error value beign shown
                    //error
                    console.log(error);
                }, async() => {
                    const downloadURL = await storageChild.getDownloadURL();
                    d = downloadURL;
                    console.log(d);
                    resolve();
                });
            });

            const fileRef = await firebase.storage().reffromURL(d); //downloads url from d

            let post = {
                title,  //comes ffom the title earlier  line 25
                content,
                cover: d, //https:firebase:my-image
                fileref: fileRef.location.path //line 68 , this gets the image.jpg
            }

            await firebase.firestore().collection("posts").add(post);  //creates a sotrage posts for  the psots, add pushs the info to the db

            console.log("post added successfully");

            if(postSubmit != null) {
                window.location.replace("main.html");
                postSubmit.disabled = false;
            } 


        } else{
            console.log("must fill remaining inputs") //checking for empty forms
        }


    })
}



//nav functions 

openNav.addEventListener("click", (e) => {
    document.getElementById("nav").style.width = "250px";
    document.getElementById("main").style.marginleft = "250px";

});

closeNav.addEventListener("click", (e) => {
    e.preventDefault();
    document.getElementById("nav").style.width = "0";
    document.getElementById("main").style.marginleft = "";
});






