package ie.ulster.exam;

class Rooms {
    private String room;
    private int capacity;
    private String feature;
    private boolean alcohol;

    Rooms (String room, int capacity, String feature, boolean alcohol)
    {
        this.room = room;
        this.capacity = capacity;
        this.feature = feature;
        this.alcohol = alcohol;
    }
	
	public String getRoom() {
		return room;
	}
	
	//public void setRoom(String room) {
	//	this.room = room;
	//}
	
	public int getCapacity() {
		return capacity;
	}
	
	//public void setCapacity (int capacity) {
	//	this.capacity = capacity;
	//}
	

	public String getFeature() {
		return feature;
	}
	
	//public void setsetFeature(String feature) {
	//	this.feature = feature;
     // }


	public boolean getAlcohol() {
		return alcohol;
	}
	
	//public void setAlcohol_allowed (boolean alcohol_allowed {
	//	this.alcohol_allowed = alcohol_allowed;
	//}
	

}