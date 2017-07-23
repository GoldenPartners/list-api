package dev.jpp.listapi.entity;

public enum EventState {
	CLOSED("closed"),
	FINISHED("finished");
	
	private String state;
	
	private EventState(String state) {
		this.state = state;
	}
	
	public String getState() {
		return this.state;
	}
}
