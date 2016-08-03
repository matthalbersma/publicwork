
function choice() {
        var temperature=["Fahrenheit", "Kelvin","Celsius"];
    var mass=["KG", "LBS"];
    var volume=["Gallon", "Liter"]
    var temp=document.getElementById("first");
    var unit=temp.options[temp.selectedIndex].value;

    switch (unit){
        case "1":
                 document.getElementById("U1").options.length=0;
                for (var i=0; i<temperature.length; i++){
                    temp=document.getElementById("U1");
                    temp.options[i]=new Option(temperature[i],temperature[i]);
                    }
                    break;
    
            
        case "2": 
            document.getElementById("U1").options.length=0;
                for (var i=0; i<mass.length; i++){
                    temp=document.getElementById("U1");
                    temp.options[i]=new Option(mass[i],mass[i]);  
                } break; 
            
        case "3":
           document.getElementById("U1").options.length=0;
            for (var i=0;i<volume.length;i++){
             temp=document.getElementById("U1");
                    temp.options[i]=new Option(volume[i],volume[i]);  
                } break; 
}
    choice1();
}
function choice1() {
    var temperature=["Fahrenheit", "Kelvin","Celsius"];
    var mass=["KG", "LBS"];
    var volume=["Gallon", "Liter"]
    
    var temp=document.getElementById("U1");
    var unit=temp.options[temp.selectedIndex].value;
    switch(unit){
        case "Fahrenheit":
            temperature.splice(0,1);
            document.getElementById("u2").options.length=0;
            for (var i=0; i<temperature.length; i++){
                temp=document.getElementById("u2");
                temp.options[i]=new Option(temperature[i],temperature[i]);
                }
                break;
            
        case "Kelvin":
            temperature.splice(1,1);
            document.getElementById("u2").options.length=0;
            for (var i=0; i<temperature.length; i++){
                temp=document.getElementById("u2");
                temp.options[i]=new Option(temperature[i],temperature[i]);
                }
                break;
        
        case "Celsius":
            temperature.splice(2,1);
            document.getElementById("u2").options.length=0;
            for (var i=0; i<temperature.length; i++){
                temp=document.getElementById("u2");
                temp.options[i]=new Option(temperature[i],temperature[i]);
                }
                break;
            
        case "KG":
            document.getElementById("u2").options.length=0;
            document.getElementById("u2").options[0]=new Option("LBS","LBS");
             break;
        case "LBS":
            document.getElementById("u2").options.length=0;
            document.getElementById("u2").options[0]=new Option("KG","KG");
             break;
            
        case "Gallon":
            document.getElementById("u2").options.length=0;
            document.getElementById("u2").options[0]=new Option("Liter","Liter");
             break;
            
        case "Liter":
            document.getElementById("u2").options.length=0;
            document.getElementById("u2").options[0]=new Option("Gallon","Gallon");
             break;
            
            
            
            
            
            
            
            
            
            
            
    }
    
    
    
    
    
}