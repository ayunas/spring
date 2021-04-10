package com.amiryunas;

class Doctor implements Worker {

	@Override
	public String work() {
		return "After 30 years of schooling, let me diagnose your condition and prescribe a suitable drug";
	}
}