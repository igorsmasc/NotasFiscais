package model;

import java.math.BigDecimal;
import java.util.List;

public record Order(String id, BigDecimal valor, String type, AdditionalMessages additionalMessages, String sellerId, String buyerId) {}

