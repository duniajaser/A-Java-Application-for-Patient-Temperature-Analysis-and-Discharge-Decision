# A-Java-Application-for-Patient-Temperature-Analysis-and-Discharge-Decision

This Java program implements a comprehensive system for monitoring hospital patients' temperatures over consecutive days. It prompts for daily temperature readings, offering insights into the patient's health status through calculations of average, maximum, and minimum temperatures.

**Key Features:**

**1. Dynamic Data Collection:** Collects multiple temperature readings per day for any number of days, ensuring flexibility in data entry.
Error Handling: Validates temperature inputs, ensuring readings are within realistic ranges (30°C to 45°C) and re-prompts for inputs if anomalies are detected.

**2. Health Analysis:** Calculates daily and overall temperature statistics including average, maximum, and minimum values, providing critical health indicators.
Temperature Trends: Identifies and counts temperature readings above or below the average, offering insights into health trends.

**3. Data Sorting:** Organizes daily temperature readings in ascending order for a clearer view of temperature progression.

**4. Discharge Criteria:** Determines a patient's eligibility for hospital discharge based on the average of the last two highest daily temperature readings, adhering to a normal temperature range (35.5°C - 36.5°C).


The program interacts with users through a series of prompts, starting with the number of days a patient has been in the hospital, followed by the number of temperature readings and their values. It concludes with a discharge eligibility check based on the last two days' temperature averages.
