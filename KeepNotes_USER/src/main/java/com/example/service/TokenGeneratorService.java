package com.example.service;


import java.util.Map;

import com.example.model.*;

public interface TokenGeneratorService {
	Map<String,String> generateToken(User user);

}