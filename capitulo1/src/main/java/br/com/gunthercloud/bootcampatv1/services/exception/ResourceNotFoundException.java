package br.com.gunthercloud.bootcampatv1.services.exception;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String msg) {
		super(msg);
	}

}
