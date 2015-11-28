<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Upload Image as IMG or Canvas and send to server as file or Blob</title>
    <body>
	<div class="select">
	    <label for="videoSource">Video source: </label><select id="videoSource" style="display:none"></select>
	</div>
	  <video muted id="monitor"  autoplay></video>
		<canvas id="photo" height="640" style="display:none" width="480" ></canvas><!-- height="640" width="480" -->
		 
		<input type="button" value="start" onClick="startVideo();" />
		<input type="button" value="snap"  onClick="captureImage();" /> 

       
        <br>
        <script type="text/javascript">
        
        var videoElement = document.querySelector('video');
      //var audioSelect = document.querySelector('select#audioSource');
      var videoSelect = document.querySelector('select#videoSource');

      navigator.getUserMedia = navigator.getUserMedia ||
        navigator.webkitGetUserMedia || navigator.mozGetUserMedia;

      function gotSources(sourceInfos) {
        for (var i = 0; i !== sourceInfos.length; ++i) {
          var sourceInfo = sourceInfos[i];
          var option = document.createElement('option');
          option.value = sourceInfo.id;
          /*if (sourceInfo.kind === 'audio') {
            option.text = sourceInfo.label || 'microphone ' +
              (audioSelect.length + 1);
            audioSelect.appendChild(option);
          } else*/
          if (sourceInfo.kind === 'video') {
            option.text = sourceInfo.label || 'camera ' + (videoSelect.length + 1);
            videoSelect.appendChild(option);
      	option.selected=true;
          } else {
            console.log('Some other kind of source: ', sourceInfo);
          }
      	
        }
        //start();
      }



      if (typeof MediaStreamTrack === 'undefined' ||
          typeof MediaStreamTrack.getSources === 'undefined') {
        alert('This browser does not support MediaStreamTrack.\n\nTry Chrome.');
      } else {
      	setLastIndexOfSelect(videoSelect);
        MediaStreamTrack.getSources(gotSources);
      }

      function successCallback(stream) {
        window.stream = stream; // make stream available to console
        videoElement.src = window.URL.createObjectURL(stream);
        videoElement.play();
        captureImage();
      }

      function errorCallback(error) {
        console.log('navigator.getUserMedia error: ', error);
      }

      function start() {
      	setLastIndexOfSelect(videoSelect);
        if (!!window.stream) {
          videoElement.src = null;
          //window.stream.stop();
        }
        //var audioSource = audioSelect.value;
        var videoSource = videoSelect.value;
        var constraints = {
    
          video: {
            mandatory: {
/*    	      minWidth: 640,
      	      minHeight: 480
     	      maxWidth: 640,
      	      maxHeight: 480 */
      	  },
            optional: [{
              sourceId: videoSource
            }]
          }
        };
        
        navigator.getUserMedia(constraints, successCallback, errorCallback);
      }

      //audioSelect.onchange = start;


      function setLastIndexOfSelect(s) {
      	for ( var i = 0; i < s.options.length; i++ ) {
      		s.options[i].selected = true;
      	}
      }

      //videoSelect.onchange = start;




      var video = document.getElementById('monitor');
      var canvas = document.getElementById('photo');
      function startVideo() {
      	start();
      }
      function captureImage() {
      	canvas.getContext('2d').drawImage(video, 0, 0);
      	
      	uploadCanvasAsImage();
      }
      
       		function canvasToBlob (canvas, type) {
                var byteString = atob(canvas.toDataURL().split(",")[1]),
                    ab = new ArrayBuffer(byteString.length),
                    ia = new Uint8Array(ab),
                    i;

                for (i = 0; i < byteString.length; i++) {
                    ia[i] = byteString.charCodeAt(i);
               	}

                return new Blob([ab], {
                    type: type
                });
            }

        	function dataURItoBlob(dataURI)
	        {
	            var byteString = atob(dataURI.split(',')[1]);
	
	            var mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0]
	
	            var ab = new ArrayBuffer(byteString.length);
	            var ia = new Uint8Array(ab);
	            for (var i = 0; i < byteString.length; i++)
	            {
	                ia[i] = byteString.charCodeAt(i);
	            }
	
	            var bb = new Blob([ab], { "type": mimeString });
	            return bb;
	        }
        	
            function uploadCanvasAsImage() {

                var data = new FormData();

                var dataUrl = canvas.toDataURL("image/jpeg");
                var blob = dataURItoBlob(dataUrl);

                var formData=new FormData();
                formData.append("blob", blob);
                formData.append("blobName", "barCode.png");
                formData.append("blobType", "image/jpeg");
                uploadToServer(formData);

            }

            
            
            function uploadToServer(formData) {
            	
            	if (window.XMLHttpRequest) { // Mozilla, Safari, ...
                	xhttp= new XMLHttpRequest();
                  //alert("Yes. Your browser must be one among them - Mozilla, Safari, Chrome, Rockmelt, IE 8.0 or above");
                } else if (window.ActiveXObject) { // IE
                  try {
                	  xhttp= new ActiveXObject("Msxml2.XMLHTTP");
                    //alert("Yes. Your browser must be IE");
                  } 
                  catch (e) {
                    try {
                    	xhttp= new ActiveXObject("Microsoft.XMLHTTP");
                      //alert("Yes. Your browser must be IE");
                    } 
                    catch (e) {}
                  }
                }
             	if (!xhttp) {
                  alert("Your browser is not supported AJAX!");
                  return false;
                }
            	xhttp.onreadystatechange = function() {
            	   if (xhttp.readyState == 4 && xhttp.status == 200) {
            	     var respTxt = xhttp.responseText;
            	     if(respTxt=="error") {
            	    	 setTimeout(captureImage, 3000);
            	    	 //alert("Barcode not found in captured image.");
            	    	 //return false;
            	     } else if(respTxt=="error_other"){
            	    	 window.stream.stop();
            	    	 alert("Some unexpected error occered. Please contact administrator. Try again later.");
            	     }else {
            	    	 document.getElementById("monitor").display="none";
            	    	 document.getElementById("photo").display="block";
            	    	 window.stream.stop();
            	    	 alert("barcode : " + respTxt);
            	     }
            	   }
            	}
            	xhttp.open("POST", "http://192.168.110.19:8080/QRCode/getScanBarcode/", true);
            	//xhttp.setRequestHeader("Content-type", "multipart/form-data");
            	xhttp.send(formData);
            }

    //        captureImage();
        /**
         * Trigger the app.
         */
        //imageUploader.init();
        </script>
    </body>

</html>
