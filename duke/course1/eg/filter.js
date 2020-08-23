var imgInput = null;
var canvas = document.getElementById("can");
function inputfile(){
  var fileInput = document.getElementById("inputfile");
  imgInput = new SimpleImage(fileInput);
  imgInput.drawTo(canvas);
}

function imageIsLoaded(image){
  if(image == null || !image.complete()){
    return false;
  }
  return true;
}

function filterGray(imgInput){
  var grayImg = new SimpleImage(imgInput.width, imgInput.height);
  for (var pixel of imgInput.values()){
    var x = pixel.getX();
    var y = pixel.getY();
    var color = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
    grayImg.setPixel(x, y, color, color, color);
  }
  return grayImg;
}

function doGray(){
  if (imageIsLoaded(imgInput)){
    filterGray();
    grayImg.drawTo(canvas);
  }
}