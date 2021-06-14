package com.minisenseapi.minisense.domain.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * MeasurementUnit
 */
@Entity
public class Unit   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String symbol;
	private String description;
	
	/**
	 * Get id
	 * @return id
	 **/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	 /**
	  * Get symbol
	  * @return symbol
	  **/
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	   * Get description
	   * @return description
	  **/
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Unit measurementUnit = (Unit) o;
    return Objects.equals(this.id, measurementUnit.id) &&
        Objects.equals(this.symbol, measurementUnit.symbol) &&
        Objects.equals(this.description, measurementUnit.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, symbol, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeasurementUnit {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    symbol: ").append(toIndentedString(symbol)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

