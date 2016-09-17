var wordList = ["existence", "marmalade", "orthography", "egalitarian", "utilitarian", "felicitous","yankee","ossify", "transubstantiation", "nair", "attenuate",
"crackerjack", "ambivalence", "litigious", "extirpate", "accoutrement", "inchoate", "vernacular", "pervicacious", "oxymoron", "arduous", "antithesis", "macguffin", "gratuitous", "exfoliate", "reticence", "nescience"];

var pick=0;
var word;
 var picked = new Array();
    var spaces = new Array();
    var wrong = new Array();
    var theSpaces="";
var choice="";
var wrongCount=0;


function wordPick() {
    pick=Math.floor(Math.random()*20)+3;
    var pickUrl="http://randomword.setgetgo.com/get.php?len="+pick;
           $.ajax({
            type: "GET",
            url: pickUrl,
            dataType: "jsonp",
            success: function (data){
      
    word=data.Word; 
    console.log(word);
    document.getElementById("start").style.visibility="hidden";
    document.getElementById("guess1").style.visibility="visible";
    for (n = 0; n < word.length; n++){
        picked[n]=word[n];
        spaces[n]="_";
        
        theSpaces += spaces[n]+" ";
        
    }
    document.getElementById("guess2").style.visibility="visible";
    document.getElementById("display").innerHTML=theSpaces;
    document.getElementById("guessbutton").style.visibility="visible";
    document.getElementById("guess3").style.visibility="visible";
            }
                 });

}
function guess() {
    document.getElementById("wrongs").style.visibility="visible";
    theSpaces="";
    choice=document.getElementById("guess").value;
   
    if (choice==""||choice.length>1||wrong.includes(choice)||!isNaN(choice)){
        alert("Invalid entry");
        document.getElementById("guess").value="";
        return;
    }
     document.getElementById("guess").value="";
    if (picked.includes(choice)){
    for (var n=0;n<picked.length;n++){
        
        if(picked[n]==choice){
            spaces[n]=choice;
        }
    }
         for (n = 0; n < word.length; n++){
        theSpaces += spaces[n]+" ";
    }
        document.getElementById("display").innerHTML=theSpaces;
        
    } else{
        wrong.push(choice);
        wrongCount++;
        
        document.getElementById("jpg").src="HMpic"+(wrongCount+1)+".png";
   
   
        document.getElementById("wrongs").innerHTML=wrong;
        }
    if(!spaces.includes("_")){
        document.getElementById("wrongs").innerHTML="You Win!";
        document.getElementById("playagain").style.visibility="visible";
    }
else if(wrongCount==6){
    document.getElementById("wrongs").innerHTML="You Lose!";
    document.getElementById("playagain").style.visibility="visible";
    }
}

function reset() {
    document.getElementById("start").style.visibility="visible";
    document.getElementById("guess1").style.visibility="hidden";
    document.getElementById("guess2").style.visibility="hidden";
    document.getElementById("guess3").style.visibility="hidden";
    document.getElementById("playagain").style.visibility="hidden";
    document.getElementById("guessbutton").style.visibility="hidden";
    document.getElementById("wrongs").style.visibility="hidden";
    pick=0;
    word="";
    picked = new Array();
    spaces = new Array();
    wrong = new Array();
    theSpaces="";
    choice="";
    wrongCount=0;
    document.getElementById("jpg").src="HMpic"+(wrongCount+1)+".png";
    document.getElementById("wrongs").innerHTML="";
    
}
