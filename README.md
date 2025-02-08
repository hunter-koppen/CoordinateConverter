## Coordinate Converter
Module that helps to convert coordinates from one format to another.

## Features
- Convert a single coordinate or a full polygon of coordinates from one format to another.
- Select the desired input and output coordinate format.
- Scale a polygon by a certain percentage.
- Calculate the surface area of a polygon.

## Usage
When only converting 1 coordinate you can use the `CoordinateConverter` NPE object together with the Java action. Simply create an object of CoordinateConverter and fill in the initial x and y coordinates, then run the java action, this will populate the x and y attributes with the converted coordinates. See `ACT_CoordinateConverter_Example` for an example.

When converting a polygon you have to supply a valid string of coordinates in the input, then the java action will return a string of converted coordinates.


## Issues, suggestions and feature requests
https://github.com/hunter-koppen/CoordinateConverter/issues
