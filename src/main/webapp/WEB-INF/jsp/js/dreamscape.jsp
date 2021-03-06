<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>

<script type="text/javascript">
	var allLooks = ${allLooksJson};
	var finalSelectedLookIndex;
	
	startOver();
	
	function startOver() {
		removeAllOptions(document.getElementById("secondDropdown"));
		removeAllOptions(document.getElementById("thirdDropdown"));
		document.getElementById("secondDropdown").hidden = true;
		document.getElementById("thirdDropdown").hidden = true;
		document.getElementById("firstGoesWellWith").hidden = true;
		document.getElementById("secondGoesWellWith").hidden = true;
		
		var videoPlayer = document.getElementById("videoPlayer");
		if(videoPlayer != null) {
			videoPlayer.parentNode.removeChild(videoPlayer);
		}
		
		var realizerDiv = document.getElementById("realizer_div");
		if(realizerDiv != null) {
			realizerDiv.innerHTML = "";
		}
		
		var realize = document.getElementById("realize");
		if(realize != null) {
    		realize.hidden = true;
    		realize.className = "";
		}
		
		var resetButton = document.getElementById("reset");
		if(resetButton != null) {
			resetButton.hidden = true;
			resetButton.className = "";
		}
		
		var firstDropDown = document.getElementById("firstDropdown");
	    for (var i = 0; i < allLooks.length; i++) {
		    var look = allLooks[i];
		    var itemList = look["items"];
		    var visualUrl = look["visualUrl"];
		    
		    for(var j = 0; j < itemList.length; j++) {
		    	var item = itemList[j];
		    	
		    	var option = new Option();
		    	option.value = i + "_" + item["type"];
		    	option.text = item["color"] + " " + item["type"];
		    	
		    	if (!exists(firstDropDown.options, option.text)) {
		    		firstDropDown.options.add(option);	
		    	}     
		    }
		}
	}
	
	function exists(options, optionText) {
		for(var i = 0; i < options.length; i++) {
			if(options[i].text == optionText) {
				return true;
			}
		}
		return false;
	}
	
    
    function removeAllOptions(dropdown) {
    	for(var i=dropdown.length-1; i>=0; i--)
        {
    		dropdown.remove(i);
        }
    	dropdown.add(new Option());
    }
    
    function nextSecondAction() {
    	removeAllOptions(document.getElementById("secondDropdown"));
    	document.getElementById("secondDropdown").hidden = true;
		document.getElementById("thirdDropdown").hidden = true;
		document.getElementById("secondGoesWellWith").hidden = true;
		removeAllOptions(document.getElementById("thirdDropdown"));
		
    	var dropdown = document.getElementById("firstDropdown");
    	var selectedLookIndex = dropdown.options[dropdown.selectedIndex].value.split("_")[0];
    	var selectedLookType = dropdown.options[dropdown.selectedIndex].value.split("_")[1];
    	
    	var selectedLook = allLooks[selectedLookIndex];
    	var selectedLookColor;
    	var selectedItem;
		for(var i = 0; i < selectedLook["items"].length; i++) {
			var item = selectedLook["items"][i];
			if(item["type"] == selectedLookType) {
				selectedLookColor = item["color"];
				selectedItem = item;
				break;
			}
		}

    	//alert(selectedLookIndex + " " + selectedLookColor + " " + selectedLookType);
    	
    	var secondDropDown = document.getElementById("secondDropdown");
    	for (var i = 0; i < allLooks.length; i++) {
    		var look = allLooks[i];
    		var itemList = look["items"];
    		
    		var otherItems = getOtherItems(itemList, selectedItem);
    		
    		 for(var j = 0; j < otherItems.length; j++) {
    			 var option = new Option();
			     option.value = i + "_" + otherItems[j]["type"];
			     option.text = otherItems[j]["color"] + " " + otherItems[j]["type"];
			     if (!exists(secondDropDown.options, option.text)) {
			     	secondDropDown.options.add(option);  
			     }
    		 }
    	}
    	
    	document.getElementById("firstGoesWellWith").hidden = false;
    	secondDropDown.hidden = false;
    }
    
    function nextThirdAction() {
    	document.getElementById("thirdDropdown").hidden = true;
		document.getElementById("secondGoesWellWith").hidden = true;
		removeAllOptions(document.getElementById("thirdDropdown"));
		
		var videoPlayer = document.getElementById("videoPlayer");
		if(videoPlayer != null) {
			videoPlayer.parentNode.removeChild(videoPlayer);
		}
		
		var realizerDiv = document.getElementById("realizer_div");
		if(realizerDiv != null) {
			realizerDiv.innerHTML = "";
		}
		
		var realize = document.getElementById("realize");
		if(realize != null) {
    		realize.hidden = true;
    		realize.className = "";
		}
		
		var resetButton = document.getElementById("reset");
		if(resetButton != null) {
			resetButton.hidden = true;
			resetButton.className = "";
		}
		
    	var firstDropdown = document.getElementById("firstDropdown");
    	var firstSelectedLookIndex = firstDropdown.options[firstDropdown.selectedIndex].value.split("_")[0];
    	var firstSelectedLookType = firstDropdown.options[firstDropdown.selectedIndex].value.split("_")[1];
    	
    	var firstSelectedLook = allLooks[firstSelectedLookIndex];
    	var firstSelectedItemColor;
    	var firstSelectedItem;
    	for(var i = 0; i < firstSelectedLook["items"].length; i++) {
			var item = firstSelectedLook["items"][i];
			if(item["type"] == firstSelectedLookType) {
				firstSelectedItemColor = item["color"];
				firstSelectedItem = item;
			}
		}
    	
    	var secondDropdown = document.getElementById("secondDropdown");
    	var secondSelectedLookIndex = secondDropdown.options[secondDropdown.selectedIndex].value.split("_")[0];
    	var secondSelectedLookType = secondDropdown.options[secondDropdown.selectedIndex].value.split("_")[1];
    	
    	var secondSelectedLook = allLooks[secondSelectedLookIndex];
    	var secondSelectedItemColor;
    	var secondSelectedItem;
    	for(var i = 0; i < secondSelectedLook["items"].length; i++) {
			var item = secondSelectedLook["items"][i];
			if(item["type"] == secondSelectedLookType) {
				secondSelectedItemColor = item["color"];
				secondSelectedItem = item;
			}
		}
		
		//alert(firstSelectedLookIndex + " " + firstSelectedItemColor + " " + firstSelectedLookType);
		//alert(secondSelectedLookIndex + " " + secondSelectedItemColor + " " + secondSelectedLookType);
		
		var thirdDropdown = document.getElementById("thirdDropdown");
    	for (var i = 0; i < allLooks.length; i++) {
    		var look = allLooks[i];
    		var itemList = look["items"];
    		
    		var otherItems = getLastItems(itemList, firstSelectedItem, secondSelectedItem);
    		
    		 for(var j = 0; j < otherItems.length; j++) {
    			 var option = new Option();
			     option.value = i + "_" + otherItems[j]["type"];
			     option.text = otherItems[j]["color"] + " " + otherItems[j]["type"];
			     if (!exists(thirdDropdown.options, option.text)) {
			     	thirdDropdown.options.add(option);
			     }
    		 }
    	}
    	
    	document.getElementById("secondGoesWellWith").hidden = false;
    	thirdDropdown.hidden = false;
    }
    
    function getLastItems(items, firstSelectedItem, secondSelectedItem) {
    	var matchesFound = 0, matchedItem;
    	for(var j = 0; j < items.length; j++) {
	    	var item = items[j];
	    	
	    	if(item["color"] == firstSelectedItem["color"] && item["type"] == firstSelectedItem["type"]) {
	    		matchesFound++;
	    	}

	    	else if(item["color"] == secondSelectedItem["color"] && item["type"] == secondSelectedItem["type"]) {
	    		matchesFound++;
	    	}
	    	else {
	    		matchedItem = item;
	    	}
		}
    	
    	var others = new Array();
    	if(matchesFound == 2) {
    		others[0] = matchedItem;
		}
    	
    	return others;
    }
    
    function getOtherItems(items, selectedItem) {
		var matchFound = false;
		for(var j = 0; j < items.length; j++) {
	    	var item = items[j];
	    	
	    	if(item["color"] == selectedItem["color"] && item["type"] == selectedItem["type"]) {
	    		matchFound = true;
	    		break;
	    	}
		}
		
		var others = new Array(), length = 0;
		
		if(matchFound) {
			for(var j = 0; j < items.length; j++) {
				var item = items[j];
				if(selectedItem["type"] == "Pants" || selectedItem["type"] == "Jeans") {
					if(item["type"] != "Pants" && item["type"] != "Jeans") {
						others[length++] = item;
					}
				}
				
				if(selectedItem["type"] == "Shirt" || selectedItem["type"] == "TShirt") {
					if(item["type"] != "Shirt" && item["type"] != "TShirt") {
						others[length++] = item;
					}
				}
				
				if(selectedItem["type"] == "Shoes") {
					if(item["type"] != "Shoes") {
						others[length++] = item;
					}
				}
			}
		}
		
		return others;
    }
    
    function visualize() {
    	var firstDropdown = document.getElementById("firstDropdown");
    	var firstSelectedLookText = firstDropdown.options[firstDropdown.selectedIndex].text;
    	
    	var secondDropdown = document.getElementById("secondDropdown");
    	var secondSelectedLookText = secondDropdown.options[secondDropdown.selectedIndex].text;
    	
    	var thirdDropdown = document.getElementById("thirdDropdown");
    	var thirdSelectedLookText = thirdDropdown.options[thirdDropdown.selectedIndex].text;
    	
    	finalSelectedLookIndex = findSelectedLookIndex(firstSelectedLookText, secondSelectedLookText, thirdSelectedLookText);
    	
    	var visualizer = document.getElementById("visualizer_div");
    	var videoPlayer = "<video id=\"videoPlayer\" width=\"430\" height=\"576\" autoplay><source id=\"visualizer_source\" type=\"video/mp4\" src=\"";
    	videoPlayer += allLooks[finalSelectedLookIndex].visualUrl;
    	videoPlayer += "\"></source></video>";
    	visualizer.innerHTML = videoPlayer;
    	
    	var realize = document.getElementById("realize");
    	realize.hidden = false;
    	realize.className = "myButtonCss";
    	
    	var resetButton = document.getElementById("reset");
    	resetButton.hidden = false;
    	resetButton.className = "myButtonCss";
    }
    
    function findSelectedLookIndex(firstSelectedLookText, secondSelectedLookText, thirdSelectedLookText) {
    	for (var i = 0; i < allLooks.length; i++) {
    		var look = allLooks[i];
    		var itemList = look["items"];
    		
    		var matchedItems = 0;
    		for(var j = 0; j < itemList.length; j++) {
    			var item = itemList[j];
    			var itemKey = item["color"] + " " + item["type"]
    			if(itemKey == firstSelectedLookText) {
    				matchedItems++;
    			}
    			if(itemKey == secondSelectedLookText) {
    				matchedItems++;
    			}
    			if(itemKey == thirdSelectedLookText) {
    				matchedItems++;
    			}
    		}
    		
    		if(matchedItems == 3) {
    			return i;
    		}
    	}
    	return -1;		// this should never happen!
    }
    
    $(document).ready(function(){
    	  $('#realize').click(function(){
    		  	//alert("click event");
				var realizer = document.getElementById("realizer_div");
				var spinnerHtml = "<br /><br /><img src=\"https://improvement-ninjas.amazon.com/s3files/s3get.cgi/loading_spinner.gif\" ";
				spinnerHtml += "alt=\"Loading...\" height=\"159\" width=\"159\">";
				realizer.innerHTML = spinnerHtml;
				
    		  	$.ajax({
    		        type: "GET",
    		        url: "/home",
    		        data: { realizeLookIndex : finalSelectedLookIndex  }
    		      }).done(function( msg ) {
    		    	  var realizer = document.getElementById("realizer_div");
    		    	  realizer.innerHTML = msg;
    		        //alert( "Data Saved: " + msg );
    		      });

    	    });
    	   });
    	
    
   
</script>