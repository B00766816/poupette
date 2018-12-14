package ie.ulster.exam;

class Rooms {
    private String room;
    private int capacity;
    private String feature;
    private boolean alcohol_allowed;

    Rooms (String room, int capacity, String feature, boolean alcohol_allowed)
    {
        this.room = room;
        this.capacity = capacity;
        this.feature = feature;
        this.alcohol_allowed = alcohol_allowed;
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
	//}


	public boolean alcohol_allowed() {
		return alcohol_allowed;
	}
	
	//public void setAlcohol_allowed (boolean alcohol_allowed {
	//	this.alcohol_allowed = alcohol_allowed;
	//}
	

}