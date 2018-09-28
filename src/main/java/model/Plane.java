package model;

public enum Plane {

	A330("A330"), A340("A340"), A380("A380"), B747("B747");
	String type;

	private Plane(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
    public String toString() {
        return this.type;
     }

}