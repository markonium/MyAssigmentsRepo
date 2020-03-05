package eg.edu.alexu.csd.datastructure.iceHockey.cs54;

public class MainClass implements IPlayersFinder {
	java.awt.Point[] results;
	public int count=0,resultSize=0,tempCount=0,modTimes=0;
	java.awt.Point[] coordinate;
	
	public java.awt.Point[] findPlayers(String[] photo, int team, int threshold){
	String[] tempPhoto=photo;
	//The function will return null in case of null or empty images
	if(photo==null || photo.length==0 || photo[0].length()==0) {
		return null;
	}coordinate=new java.awt.Point[2*photo.length*photo[0].length()];
	for(int i=0;i<2*photo.length*photo[0].length();i++) {
		coordinate[i]=new java.awt.Point(0,0);
	}
	for(int i=0;i<photo.length;i++) {
		for(int j=0;j< photo[0].length();j++) {
			char p=tempPhoto[i].charAt(j);
			if(p-48==team) {
				search(i,j,photo.length,photo[0].length(),tempPhoto,team);
				coordinate[count]=new java.awt.Point(-1,-1);
				count++;
			}
		}
	}
	setResult(0,threshold);
	results=new java.awt.Point[resultSize];
	for(int i=0;i<resultSize;i++) {
		results[i]=new java.awt.Point(0,0);
	}
	setResult(1,threshold);
	arrange();
	return results;
	}
	
	public void setResult(int op,int threshold) {
		int iTemp=0,z;
		while(iTemp<count) {
		for(z=iTemp;z<count;z++) {
			if(coordinate[z].x!=-1 && coordinate[z].y!=-1 ) {
				tempCount++;
			}else {
				break;
			}
		}if((double)tempCount >= (double)threshold/4) {
			if(op==0) {
			resultSize++;
			}else {
				findPlayersCoordinate(iTemp,z);
			}
		}tempCount=0; iTemp=z+1;
		}
	}
	
	public void search(int x,int y,int xlim,int ylim,String[]tempPhoto,int team) {
		count++;
		coordinate[count-1]=new java.awt.Point(x+1,y+1);
		
		char[] tempChar = tempPhoto[x].toCharArray();
		tempChar[y] =(char) (tempChar[y]+1) ;
		tempPhoto[x] = String.valueOf(tempChar);
		
		if(x-1 >= 0) {
			if(tempPhoto[x-1].charAt(y)-48==team) {
				search(x-1,y,xlim,ylim,tempPhoto,team);
			}
		}if(x+1 < xlim) {
			if(tempPhoto[x+1].charAt(y)-48==team) {
				search(x+1,y,xlim,ylim,tempPhoto,team);
			}
		}if(y-1 >= 0) {
			if(tempPhoto[x].charAt(y-1)-48==team) {
				search(x,y-1,xlim,ylim,tempPhoto,team);
			}
		}if(y+1 < ylim) {
			if(tempPhoto[x].charAt(y+1)-48==team) {
				search(x,y+1,xlim,ylim,tempPhoto,team);
			}
		}
	}
	
	public void findPlayersCoordinate(int limitStart,int limitEnd) {
		int xmin=coordinate[limitStart].x,xmax=coordinate[limitStart].x,ymin=coordinate[limitStart].y,ymax=coordinate[limitStart].y;
		if(limitEnd-limitStart>1) {
		for(int i=limitStart;i<limitEnd;i++) {
			if(xmin>coordinate[i].x) {
				xmin=coordinate[i].x;
			}if(xmax<coordinate[i].x) {
				xmax=coordinate[i].x;
			}if(ymin>coordinate[i].y) {
				ymin=coordinate[i].y;
			}if(ymax<coordinate[i].y) {
				ymax=coordinate[i].y;
			}
		}results[modTimes].x=ymin+ymax-1; results[modTimes].y=xmin+xmax-1;
		}else {
			results[modTimes].x=2*coordinate[limitStart].x-1; results[modTimes].y=2*coordinate[limitStart].x-1;
		} modTimes++;
	}
	public void arrange() {
		for( int i = 1; i < resultSize; i++ ){
		java.awt.Point temp = results[i];
		// find the insertion location and move all larger elements up
		int pos = i;
		while (pos>0 && temp.x < results[pos-1].x){
					results[pos] = results[pos-1];
					pos--;
		}
		results[pos] = temp;
		}
		
	}

	
	public static void main(String[] args) {
		java.awt.Point[] results1;
		String[] arr=null;
		MainClass b=new MainClass();
		results1=b.findPlayers(arr,9,50);
		for(int i=0;i<b.resultSize;i++) {
			System.out.print("("+results1[i].x+","+results1[i].y+")"+",");
		}
	}
}
