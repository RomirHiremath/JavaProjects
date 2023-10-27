package myapp;

/**
 * An instance of type StarbucksCorporation keeps track of all StarbucksStore
 * elements that are added to the corporation. Enables the user to ask some
 * questions about the store data stored via accessor methods.
 */
public class StarbucksCorporation
{
    // TODO: Define the following attributes with "private" visibility:
    // "allStores" a one-dimensional array of StarbuckStore objects, which keeps track of
    // all stores in our test set.
    // "MIN_NUM_STORES" a constant of type int set to the value 2.
    /**
     * Hard-coded 2D array representation of a data input file. Note: 2D array
     * should not be referenced outside of this class. The number of indices for
     * COMPLETE_CSV_DATA_IN_ROWS may change.
     */
    private final static String[][] COMPLETE_CSV_DATA_IN_ROWS =
    {
            // {"Store","Location","State","RTWState","FileDate","VoteCountDate","FileToCountDays","VotesYes","VotesNo","VoteTotal","EligibleVoters","Turnout","Margin","YesPercent","Result"},
            { "20th Street and 3rd Ave", "Birmingham, AL", "AL", "Yes", "4/11/22", "5/26/22", "45", "27", "1", "28",
                    "33", "0.8485", "0.9286", "0.9643", "Yes" },
            { "Power & Baseline Road", "Mesa, AZ", "AZ", "Yes", "11/18/21", "2/25/22", "99", "25", "3", "28", "43",
                    "0.6512", "0.7857", "0.8929", "Yes" },
            { "Crismon & Southern", "Mesa, AZ", "AZ", "Yes", "1/18/22", "3/25/22", "66", "11", "3", "14", "28", "0.5",
                    "0.5714", "0.7857", "Yes" },
            { "Indian School & 107th Ave", "Avondale, AZ", "AZ", "Yes", "2/28/22", "5/5/22", "66", "17", "3", "20",
                    "30", "0.6667", "0.7", "0.85", "Yes" },
            { "7th Street & Bell", "Phoenix, AZ", "AZ", "Yes", "2/23/22", "5/5/22", "71", "7", "6", "13", "28",
                    "0.4643", "0.0769", "0.5385", "Yes" },
            { "54th St. & Ray Rd., Chandler", "Chandler, AZ", "AZ", "Yes", "3/29/22", "6/9/22", "72", "1", "9", "10",
                    "17", "0.5882", "-0.8", "0.1", "No" },
            { "Mission & Dufour", "Santa Cruz, CA", "CA", "No", "1/31/22", "5/11/22", "100", "14", "2", "16", "32",
                    "0.5", "0.75", "0.875", "Yes" },
            { "Ocean & Water", "Santa Cruz, CA", "CA", "No", "1/21/22", "5/11/22", "110", "13", "1", "14", "28", "0.5",
                    "0.8571", "0.9286", "Yes" },
            { "Candlewood St. & Lakewood Blvd.", "Lakewood, CA", "CA", "No", "3/7/22", "5/13/22", "67", "24", "1", "25",
                    "33", "0.7576", "0.92", "0.96", "Yes" },
            { "Redondo & 7th", "Long Beach, CA", "CA", "No", "3/7/22", "5/13/22", "67", "13", "0", "13", "23", "0.5652",
                    "1", "1", "Yes" },
            { "2nd & Central", "Los Angeles, CA", "CA", "No", "3/15/22", "5/23/22", "69", "5", "0", "5", "19", "0.2632",
                    "1", "1", "Yes" },
            { "Katella & Los Alamitos", "Los Alamitos, CA", "CA", "No", "3/16/22", "5/23/22", "68", "2", "11", "13",
                    "19", "0.6842", "-0.6923", "0.1538", "No" },
            { "Clares & 41st", "Capitola, CA", "CA", "No", "3/30/22", "6/6/22", "68", "8", "3", "11", "21", "0.5238",
                    "0.4545", "0.7273", "Yes" },
            { "Katella & Anaheim", "Anaheim, CA", "CA", "No", "3/28/22", "6/9/22", "73", "10", "1", "11", "29",
                    "0.3793", "0.8182", "0.9091", "Yes" },
            { "Downtown Disney Store", "Anaheim, CA", "CA", "No", "3/28/22", "6/16/22", "80", "29", "15", "44", "90",
                    "0.4889", "0.3182", "0.6591", "Yes" },
            { "Hwy 111 & Jefferson, La Quinta", "La Quinta, CA", "CA", "No", "4/11/22", "6/21/22", "71", "5", "4", "9",
                    "35", "0.2571", "0.1111", "0.5556", "Yes" },
            { "2nd & Covina", "Long Beach, CA", "CA", "No", "4/11/22", "6/21/22", "71", "3", "5", "8", "22", "0.3636",
                    "-0.25", "0.375", "No" },
            { "Citrus & Rowland", "Covina, CA", "CA", "No", "4/11/22", "6/21/22", "71", "7", "10", "17", "36", "0.4722",
                    "-0.1765", "0.4118", "No" },
            { "Mason & Lassen", "Los Angeles, CA", "CA", "No", "2/2/22", "6/29/22", "147", "6", "9", "15", "35",
                    "0.4286", "-0.2", "0.4", "No" },
            { "Rock Creek Parkway", "Superior, CO", "CO", "No", "12/30/21", "4/22/22", "113", "12", "2", "14", "30",
                    "0.4667", "0.7143", "0.8571", "Yes" },
            { "E Colfax Ave", "Denver, CO", "CO", "No", "1/27/22", "5/10/22", "103", "13", "0", "13", "23", "0.5652",
                    "1", "1", "Yes" },
            { "S. Nevada and Brookside", "Colorado Springs, CO", "CO", "No", "3/10/22", "5/19/22", "70", "13", "0",
                    "13", "24", "0.5417", "1", "1", "Yes" },
            { "Holly & Leetsdale", "Denver, CO", "CO", "No", "3/21/22", "5/19/22", "59", "9", "1", "10", "24", "0.4167",
                    "0.8", "0.9", "Yes" },
            { "16th & Tremont", "Denver, CO", "CO", "No", "3/4/22", "5/19/22", "76", "4", "1", "5", "26", "0.1923",
                    "0.6", "0.8", "Yes" },
            { "Garden of the Gods at Centennial", "Colorado Springs, CO", "CO", "No", "4/6/22", "6/8/22", "63", "12",
                    "4", "16", "28", "0.5714", "0.5", "0.75", "Yes" },
            { "3rd and Columbine - Cherry Creek", "Denver, CO", "CO", "No", "4/12/22", "6/13/22", "62", "8", "5", "13",
                    "23", "0.5652", "0.2308", "0.6154", "Yes" },
            { "Corbin's Corner", "West Hartford, CT", "CT", "No", "4/18/22", "6/9/22", "52", "13", "3", "16", "22",
                    "0.7273", "0.625", "0.8125", "Yes" },
            { "Palm Springs Mile", "Hialeah, FL", "FL", "Yes", "3/9/22", "4/20/22", "42", "12", "14", "26", "37",
                    "0.7027", "-0.0769", "0.4615", "No" },
            { "8th Ave & 49th St", "Miami, FL", "FL", "Yes", "2/14/22", "4/22/22", "67", "13", "14", "27", "37",
                    "0.7297", "-0.037", "0.4815", "No" },
            { "John Knox & N. Monroe St", "Tallahassee, FL", "FL", "Yes", "1/11/22", "5/3/22", "112", "16", "1", "17",
                    "35", "0.4857", "0.8824", "0.9412", "Yes" },
            { "Ben Hill Griffin Parkway", "Estero, FL", "FL", "Yes", "3/22/22", "5/6/22", "45", "11", "21", "32", "37",
                    "0.8649", "-0.3125", "0.3438", "No" },
            { "52 Curtiss Pkwy", "Miami Springs, FL", "FL", "Yes", "3/15/22", "5/10/22", "56", "10", "3", "13", "17",
                    "0.7647", "0.5385", "0.7692", "Yes" },
            { "San Jose Blvd & Ricky Drive", "Jacksonville, FL", "FL", "Yes", "2/16/22", "5/10/22", "83", "10", "7",
                    "17", "25", "0.68", "0.1765", "0.5882", "Yes" },
            { "1980 Can Marco Blvd", "Jacksonville, FL", "FL", "Yes", "2/25/22", "5/10/22", "74", "8", "1", "9", "14",
                    "0.6429", "0.7778", "0.8889", "Yes" },
            { "Mitchell Hammock & City Plaza", "Oviedo, FL", "FL", "Yes", "3/4/22", "6/9/22", "97", "24", "6", "30",
                    "42", "0.7143", "0.6", "0.8", "Yes" },
            { "Augusta Exchange", "Augusta, GA", "GA", "Yes", "3/14/22", "4/28/22", "45", "26", "5", "31", "38",
                    "0.8158", "0.6774", "0.8387", "Yes" },
            { "Hwy 278 & Pace", "Covington, GA", "GA", "Yes", "4/21/22", "6/1/22", "41", "4", "18", "22", "30",
                    "0.7333", "-0.6364", "0.1818", "No" },
            { "I-75 & Howell Mill", "Atlanta, GA", "GA", "Yes", "1/27/22", "6/6/22", "130", "10", "1", "11", "34",
                    "0.3235", "0.8182", "0.9091", "Yes" },
            { "Ansley Mall", "Atlanta, GA", "GA", "Yes", "5/2/22", "6/22/22", "51", "11", "3", "14", "15", "0.9333",
                    "0.5714", "0.7857", "Yes" },
            { "Mililani Shopping Center", "Mililani, HI", "HI", "No", "2/11/22", "5/2/22", "80", "7", "8", "15", "17",
                    "0.8824", "-0.0667", "0.4667", "No" },
            { "Northwest Hwy & Feinberg Drive", "Cary, IL", "IL", "No", "2/14/22", "4/26/22", "71", "17", "4", "21",
                    "27", "0.7778", "0.619", "0.8095", "Yes" },
            { "University & Main", "Peoria, IL", "IL", "No", "2/14/22", "4/26/22", "71", "9", "2", "11", "18", "0.6111",
                    "0.6364", "0.8182", "Yes" },
            { "Downtown La Grange", "La Grange, IL", "IL", "No", "1/14/22", "5/6/22", "112", "6", "9", "15", "18",
                    "0.8333", "-0.2", "0.4", "No" },
            { "Ridge & Clark", "Chicago, IL", "IL", "No", "3/24/22", "5/25/22", "62", "20", "3", "23", "29", "0.7931",
                    "0.7391", "0.8696", "Yes" },
            { "W. Bryn Mawr & Winthrop - Edgewater", "Chicago, IL", "IL", "No", "4/7/22", "5/25/22", "48", "10", "1",
                    "11", "14", "0.7857", "0.8182", "0.9091", "Yes" },
            { "55th & Woodlawn - Hyde Park", "Chicago, IL", "IL", "No", "1/14/22", "6/7/22", "144", "5", "3", "8", "16",
                    "0.5", "0.25", "0.625", "Yes" },
            { "Randolph & Wabash", "Chicago, IL", "IL", "No", "12/30/21", "6/7/22", "159", "6", "7", "13", "25", "0.52",
                    "-0.0769", "0.4615", "No" },
            { "Logan & California", "Chicago, IL", "IL", "No", "3/30/22", "6/7/22", "69", "8", "10", "18", "25", "0.72",
                    "-0.1111", "0.4444", "No" },
            { "Armitage & Hoyne - Bucktown", "Chicago, IL", "IL", "No", "3/28/22", "6/14/22", "78", "15", "1", "16",
                    "29", "0.5517", "0.875", "0.9375", "Yes" },
            { "23rd & Ousdahl", "Lawrence, KA", "KA", "Yes", "3/28/22", "6/7/22", "71", "19", "3", "22", "36", "0.6111",
                    "0.7273", "0.8636", "Yes" },
            { "Overland Park - 75th & I-35", "Overland Park, KS", "KS", "Yes", "1/31/22", "4/8/22", "67", "6", "1", "7",
                    "20", "0.35", "0.7143", "0.8571", "Yes" },
            { "LaGrange and Factory", "Louisville, KY", "KY", "Yes", "3/15/22", "5/26/22", "72", "19", "5", "24", "43",
                    "0.5581", "0.5833", "0.7917", "Yes" },
            { "7700 Maple Street", "New Orleans, LA", "LA", "Yes", "4/19/22", "6/4/22", "46", "11", "1", "12", "16",
                    "0.75", "0.8333", "0.9167", "Yes" },
            { "Harvard St", "Boston, MA", "MA", "No", "12/13/21", "4/11/22", "119", "14", "0", "14", "21", "0.6667",
                    "1", "1", "Yes" },
            { "Commonwealth Ave", "Boston, MA", "MA", "No", "1/13/22", "4/11/22", "88", "11", "0", "11", "29", "0.3793",
                    "1", "1", "Yes" },
            { "Watertown - Mt. Auburn", "Watertown, MA", "MA", "No", "1/21/22", "5/3/22", "102", "10", "1", "11", "27",
                    "0.4074", "0.8182", "0.9091", "Yes" },
            { "Cleveland Circle", "Boston, MA", "MA", "No", "1/19/22", "5/3/22", "104", "8", "2", "10", "22", "0.4545",
                    "0.6", "0.8", "Yes" },
            { "Allston Continuum", "Boston, MA", "MA", "No", "1/19/22", "5/3/22", "104", "7", "0", "7", "14", "0.5",
                    "1", "1", "Yes" },
            { "Beth Israel", "Boston, MA", "MA", "No", "1/19/22", "5/3/22", "104", "5", "0", "5", "15", "0.3333", "1",
                    "1", "Yes" },
            { "Waban", "Waban, MA", "MA", "No", "3/12/22", "5/19/22", "68", "12", "0", "12", "23", "0.5217", "1", "1",
                    "Yes" },
            { "Worcester, East Central Street", "Worcester, MA", "MA", "No", "3/26/22", "6/3/22", "69", "14", "0", "14",
                    "35", "0.4", "1", "1", "Yes" },
            { "Westford Valley Marketplace", "Westford, MA", "MA", "No", "3/30/22", "6/3/22", "65", "11", "0", "11",
                    "26", "0.4231", "1", "1", "Yes" },
            { "874 Commonwealth Ave", "Brookline, MA", "MA", "No", "3/26/22", "6/3/22", "69", "10", "0", "10", "27",
                    "0.3704", "1", "1", "Yes" },
            { "Tremont-South End", "Boston, MA", "MA", "No", "3/24/22", "6/3/22", "71", "4", "0", "4", "32", "0.125",
                    "1", "1", "Yes" },
            { "443 Boylston Street", "Boston, MA", "MA", "No", "4/4/22", "6/9/22", "66", "5", "1", "6", "24", "0.25",
                    "0.6667", "0.8333", "Yes" },
            { "Gardner, W. Broadway", "Gardner, MA", "MA", "No", "4/18/22", "6/23/22", "66", "14", "0", "14", "30",
                    "0.4667", "1", "1", "Yes" },
            { "Newtonville", "Newtonville, MA", "MA", "No", "2/17/22", "6/30/22", "133", "2", "5", "7", "12", "0.5833",
                    "-0.4286", "0.2857", "No" },
            { "Kendall Square", "Cambridge, MA", "MA", "No", "2/17/22", "6/30/22", "133", "6", "0", "6", "26", "0.2308",
                    "1", "1", "Yes" },
            { "N Charles St", "Baltimore, MD", "MD", "No", "1/20/22", "4/25/22", "95", "14", "0", "14", "22", "0.6364",
                    "1", "1", "Yes" },
            { "1700 W Nursery Road", "Linthicum, MD", "MD", "No", "3/8/22", "5/10/22", "63", "15", "2", "17", "23",
                    "0.7391", "0.7647", "0.8824", "Yes" },
            { "16806 Georgia Ave - Olney", "Olney, MD", "MD", "No", "4/6/22", "5/20/22", "44", "9", "4", "13", "14",
                    "0.9286", "0.3846", "0.6923", "Yes" },
            { "Nottingham Square Shopping Center", "White Marsh, MD", "MD", "No", "4/4/22", "6/1/22", "58", "10", "2",
                    "12", "19", "0.6316", "0.6667", "0.8333", "Yes" },
            { "Route 1 Bel Air Plaza", "Bel Air, MD", "MD", "No", "4/2/22", "6/1/22", "60", "8", "5", "13", "33",
                    "0.3939", "0.2308", "0.6154", "Yes" },
            { "50 E & Thompson Creek, Kent Island", "Stevensville, MD", "MD", "No", "4/2/22", "6/1/22", "60", "6", "3",
                    "9", "22", "0.4091", "0.3333", "0.6667", "Yes" },
            { "Burton & Rosemont", "Grand Rapids, MI", "MI", "Yes", "3/7/22", "5/13/22", "67", "15", "3", "18", "30",
                    "0.6", "0.6667", "0.8333", "Yes" },
            { "Main & Liberty", "Ann Arbor, MI", "MI", "Yes", "2/4/22", "6/7/22", "123", "10", "3", "13", "19",
                    "0.6842", "0.5385", "0.7692", "Yes" },
            { "South University & Church", "Ann Arbor, MI", "MI", "Yes", "2/4/22", "6/7/22", "123", "10", "2", "12",
                    "29", "0.4138", "0.6667", "0.8333", "Yes" },
            { "State & Liberty", "Ann Arbor, MI", "MI", "Yes", "2/4/22", "6/7/22", "123", "15", "1", "16", "33",
                    "0.4848", "0.875", "0.9375", "Yes" },
            { "Jackson & Zeeb", "Ann Arbor, MI", "MI", "Yes", "1/28/22", "6/7/22", "130", "10", "2", "12", "29",
                    "0.4138", "0.6667", "0.8333", "Yes" },
            { "Glencoe Crossing", "Ann Arbor, MI", "MI", "Yes", "1/28/22", "6/7/22", "130", "14", "0", "14", "30",
                    "0.4667", "1", "1", "Yes" },
            { "Grand River & Stoddard", "East Lansing, MI", "MI", "Yes", "3/7/22", "6/9/22", "94", "19", "0", "19",
                    "32", "0.5938", "1", "1", "Yes" },
            { "Miller Road & I-75", "Flint, MI", "MI", "Yes", "3/7/22", "6/9/22", "94", "13", "6", "19", "26", "0.7308",
                    "0.3684", "0.6842", "Yes" },
            { "Lake Lansing & Kerry St", "Lansing, MI", "MI", "Yes", "2/4/22", "6/9/22", "125", "13", "3", "16", "37",
                    "0.4324", "0.625", "0.8125", "Yes" },
            { "S. Saginaw Street", "Grand Blanc, MI", "MI", "Yes", "1/28/22", "6/9/22", "132", "8", "13", "21", "30",
                    "0.7", "-0.2381", "0.381", "No" },
            { "The Mall at Partridge Creek", "Clinton Township, MI", "MI", "Yes", "1/28/22", "6/9/22", "132", "8", "3",
                    "11", "15", "0.7333", "0.4545", "0.7273", "Yes" },
            { "Carpenter Rd.", "Ann Arbor, MI", "MI", "Yes", "4/12/22", "6/17/22", "66", "15", "2", "17", "38",
                    "0.4474", "0.7647", "0.8824", "Yes" },
            { "300 Snelling", "St. Paul, MN", "MN", "No", "2/14/22", "4/27/22", "72", "14", "1", "15", "20", "0.75",
                    "0.8667", "0.9333", "Yes" },
            { "47th and Cedar", "Minneapolis, MN", "MN", "No", "2/27/22", "5/2/22", "64", "11", "3", "14", "31",
                    "0.4516", "0.5714", "0.7857", "Yes" },
            { "37th & Silver Lake Road", "St. Anthony, MN", "MN", "No", "3/22/22", "6/6/22", "76", "15", "5", "20",
                    "29", "0.6897", "0.5", "0.75", "Yes" },
            { "5351 Lyndale Avenue South", "Minneapolis, MN", "MN", "No", "3/30/22", "6/14/22", "76", "5", "6", "11",
                    "17", "0.6471", "-0.0909", "0.4545", "No" },
            { "Mall of America - First Level", "Bloomington, MN", "MN", "No", "4/14/22", "6/22/22", "69", "10", "1",
                    "11", "22", "0.5", "0.8182", "0.9091", "Yes" },
            { "Hwy 169 & Anderson Lakes Pkwy", "Eden Prarie, MN", "MN", "No", "4/21/22", "7/1/22", "71", "8", "9", "17",
                    "26", "0.6538", "-0.0588", "0.4706", "No" },
            { "E 39th and Arrowhead", "Independence, MO", "MO", "Yes", "3/7/22", "5/24/22", "78", "17", "3", "20", "29",
                    "0.6897", "0.7", "0.85", "Yes" },
            { "Natural Bridge & St. Charles Rock Rd", "Bridgeton, MO", "MO", "Yes", "4/1/22", "6/13/22", "73", "9",
                    "14", "23", "41", "0.561", "-0.2174", "0.3913", "No" },
            { "Lindbergh & Clayton", "Ladue, MO", "MO", "Yes", "3/29/22", "6/13/22", "76", "12", "3", "15", "30", "0.5",
                    "0.6", "0.8", "Yes" },
            { "Kings & Chippewa", "St. Louis, MO", "MO", "Yes", "4/4/22", "6/14/22", "71", "9", "4", "13", "27",
                    "0.4815", "0.3846", "0.6923", "Yes" },
            { "Hampton & Wise", "St. Louis, MO", "MO", "Yes", "4/4/22", "6/17/22", "74", "17", "0", "17", "25", "0.68",
                    "1", "1", "Yes" },
            { "41st & Main", "Kansas City, MO", "MO", "Yes", "3/22/22", "6/22/22", "92", "5", "4", "9", "37", "0.2432",
                    "0.1111", "0.5556", "Yes" },
            { "Hwy 141 & I-44", "Valley Park, MO", "MO", "Yes", "4/22/22", "7/7/22", "76", "11", "6", "17", "23",
                    "0.7391", "0.2941", "0.6471", "Yes" },
            { "Pride Drive & Blowing Rock Road", "Boone, NC", "NC", "Yes", "4/4/22", "4/30/22", "26", "33", "2", "35",
                    "48", "0.7292", "0.8857", "0.9429", "Yes" },
            { "Wake Forest Rd and Six Forks Rd", "Raleigh, NC", "NC", "Yes", "2/15/22", "5/3/22", "77", "5", "7", "12",
                    "12", "1", "-0.1667", "0.4167", "No" },
            { "Charlotte Street", "Asheville, NC", "NC", "Yes", "3/29/22", "5/11/22", "43", "6", "11", "17", "23",
                    "0.7391", "-0.2941", "0.3529", "No" },
            { "Hopewell", "Pennington, NJ", "NJ", "No", "1/11/22", "4/25/22", "104", "15", "0", "15", "26", "0.5769",
                    "1", "1", "Yes" },
            { "1087 White Horse Ave", "Hamilton, NJ", "NJ", "No", "2/25/22", "5/2/22", "66", "8", "3", "11", "28",
                    "0.3929", "0.4545", "0.7273", "Yes" },
            { "Summit", "Summit, NJ", "NJ", "No", "3/2/22", "5/2/22", "61", "7", "3", "10", "18", "0.5556", "0.4",
                    "0.7", "Yes" },
            { "Elmwood", "Buffalo, NY", "NY", "No", "8/30/21", "12/9/21", "101", "19", "8", "27", "36", "0.75",
                    "0.4074", "0.7037", "Yes" },
            { "Genessee St", "Buffalo, NY", "NY", "No", "8/30/21", "12/9/21", "101", "15", "9", "24", "46", "0.5217",
                    "0.25", "0.625", "Yes" },
            { "Camp Road Hamburg", "Buffalo, NY", "NY", "No", "8/30/21", "12/9/21", "101", "8", "12", "20", "30",
                    "0.6667", "-0.2", "0.4", "No" },
            { "Sheridan & Bailey", "Buffalo, NY", "NY", "No", "11/9/21", "3/9/22", "120", "15", "12", "27", "44",
                    "0.6136", "0.1111", "0.5556", "Yes" },
            { "Transit Commons / Depew", "Buffalo, NY", "NY", "No", "11/9/21", "3/9/22", "120", "15", "12", "27", "37",
                    "0.7297", "0.1111", "0.5556", "Yes" },
            { "New York Reserve Roastery", "New York, NY", "NY", "No", "2/9/22", "4/1/22", "51", "46", "36", "82", "86",
                    "0.9535", "0.122", "0.561", "Yes" },
            { "Delaware & Chippewa", "Buffalo, NY", "NY", "No", "1/31/22", "4/7/22", "66", "18", "1", "19", "27",
                    "0.7037", "0.8947", "0.9474", "Yes" },
            { "Mount Hope Ave", "Rochester, NY", "NY", "No", "1/31/22", "4/7/22", "66", "13", "11", "24", "41",
                    "0.5854", "0.0833", "0.5417", "Yes" },
            { "Brighton Monroe & Clover", "Rochester, NY", "NY", "No", "1/31/22", "4/7/22", "66", "10", "3", "13", "30",
                    "0.4333", "0.5385", "0.7692", "Yes" },
            { "College Ave", "Ithaca, NY", "NY", "No", "1/31/22", "4/8/22", "67", "19", "1", "20", "27", "0.7407",
                    "0.9", "0.95", "Yes" },
            { "Commons", "Ithaca, NY", "NY", "No", "1/31/22", "4/8/22", "67", "15", "1", "16", "25", "0.64", "0.875",
                    "0.9375", "Yes" },
            { "Meadow St", "Ithaca, NY", "NY", "No", "1/31/22", "4/8/22", "67", "13", "1", "14", "27", "0.5185",
                    "0.8571", "0.9286", "Yes" },
            { "Astor Place / Lafayette & 8th St", "New York, NY", "NY", "No", "2/10/22", "4/29/22", "78", "11", "2",
                    "13", "30", "0.4333", "0.6923", "0.8462", "Yes" },
            { "Massapequa Village Square", "Massapequa, NY", "NY", "No", "2/16/22", "5/3/22", "76", "19", "8", "27",
                    "36", "0.75", "0.4074", "0.7037", "Yes" },
            { "Ceasar's Bay Shopping Center", "Brooklyn, NY", "NY", "No", "2/9/22", "5/3/22", "83", "17", "0", "17",
                    "20", "0.85", "1", "1", "Yes" },
            { "The Gardens", "Great Neck Plaza, NY", "NY", "No", "2/9/22", "5/3/22", "83", "5", "6", "11", "14",
                    "0.7857", "-0.0909", "0.4545", "No" },
            { "Latham Plaza", "Latham, NY", "NY", "No", "3/29/22", "5/17/22", "49", "8", "6", "14", "19", "0.7368",
                    "0.1429", "0.5714", "Yes" },
            { "Nanuet", "Nanuet, NY", "NY", "No", "4/14/22", "6/3/22", "50", "14", "5", "19", "22", "0.8636", "0.4737",
                    "0.7368", "Yes" },
            { "Astoria Blvd & 31st St", "Queens, NY", "NY", "No", "3/18/22", "6/6/22", "80", "11", "0", "11", "13",
                    "0.8462", "1", "1", "Yes" },
            { "Stuyvesant Plaza", "Albany, NY", "NY", "No", "4/18/22", "6/7/22", "50", "15", "0", "15", "20", "0.75",
                    "1", "1", "Yes" },
            { "Gallery Shopping Center at Westbury", "Garden City, NY", "NY", "No", "4/14/22", "6/10/22", "57", "23",
                    "0", "23", "24", "0.9583", "1", "1", "Yes" },
            { "East Robinson at Niagara Falls Blvd", "Buffalo, NY", "NY", "No", "4/18/22", "6/16/22", "59", "7", "4",
                    "11", "35", "0.3143", "0.2727", "0.6364", "Yes" },
            { "154 N Seventh St. - Starbucks Reserve", "Brooklyn, NY", "NY", "No", "4/14/22", "6/21/22", "68", "10",
                    "0", "10", "18", "0.5556", "1", "1", "Yes" },
            { "31st St & Ditmars Blvd - Astoria", "Queens, NY", "NY", "No", "4/14/22", "6/30/22", "77", "7", "4", "11",
                    "25", "0.44", "0.2727", "0.6364", "Yes" },
            { "6th Street", "Cleveland, OH", "OH", "No", "1/10/22", "5/24/22", "134", "10", "0", "10", "22", "0.4545",
                    "1", "1", "Yes" },
            { "88 E. Broad Street", "Columbus, OH", "OH", "No", "3/22/22", "5/24/22", "63", "8", "4", "12", "13",
                    "0.9231", "0.3333", "0.6667", "Yes" },
            { "4th and Vine", "Cincinnati, OH", "OH", "No", "4/12/22", "6/23/22", "72", "9", "1", "10", "19", "0.5263",
                    "0.8", "0.9", "Yes" },
            { "Westerville", "Westerville, OH", "OH", "No", "4/13/22", "6/29/22", "77", "8", "2", "10", "30", "0.3333",
                    "0.6", "0.8", "Yes" },
            { "23rd & Robinson", "Oklahoma City, OK", "OK", "Yes", "3/16/22", "5/31/22", "76", "15", "2", "17", "31",
                    "0.5484", "0.7647", "0.8824", "Yes" },
            { "36th & May", "Oklahoma City, OK", "OK", "Yes", "4/1/22", "6/14/22", "74", "14", "1", "15", "30", "0.5",
                    "0.8667", "0.9333", "Yes" },
            { "Hwy 9 & Classen Blvd", "Norman, OK", "OK", "Yes", "3/9/22", "7/6/22", "119", "8", "8", "16", "38",
                    "0.4211", "0", "0.5", "No" },
            { "29th & Willamette", "Eugene, OR", "OR", "No", "2/11/22", "4/13/22", "61", "17", "0", "17", "28",
                    "0.6071", "1", "1", "Yes" },
            { "U of O Erb Memorial Student Union", "Eugene, OR", "OR", "No", "2/6/22", "4/28/22", "81", "19", "0", "19",
                    "28", "0.6786", "1", "1", "Yes" },
            { "Franklin & Villard", "Eugene, OR", "OR", "No", "1/31/22", "4/28/22", "87", "17", "0", "17", "27",
                    "0.6296", "1", "1", "Yes" },
            { "7th & Washington", "Eugene, OR", "OR", "No", "1/31/22", "4/28/22", "87", "12", "1", "13", "19", "0.6842",
                    "0.8462", "0.9231", "Yes" },
            { "Delta & Green Acres", "Eugene, OR", "OR", "No", "2/6/22", "4/28/22", "81", "10", "1", "11", "25", "0.44",
                    "0.8182", "0.9091", "Yes" },
            { "Oakway Mall", "Eugene, OR", "OR", "No", "1/31/22", "4/28/22", "87", "4", "7", "11", "17", "0.6471",
                    "-0.2727", "0.3636", "No" },
            { "Valley River Drive", "Eugene, OR", "OR", "No", "3/1/22", "5/5/22", "65", "10", "3", "13", "27", "0.4815",
                    "0.5385", "0.7692", "Yes" },
            { "West 11th & Acorn Park", "Eugene, OR", "OR", "No", "2/28/22", "5/5/22", "66", "7", "2", "9", "25",
                    "0.36", "0.5556", "0.7778", "Yes" },
            { "SE Powell & 28th", "Portland, OR", "OR", "No", "3/4/22", "5/17/22", "74", "14", "2", "16", "23",
                    "0.6957", "0.75", "0.875", "Yes" },
            { "23rd & Burnside", "Portland, OR", "OR", "No", "3/4/22", "5/17/22", "74", "9", "2", "11", "22", "0.5",
                    "0.6364", "0.8182", "Yes" },
            { "NE Grand & Lloyd", "Portland, OR", "OR", "No", "3/4/22", "5/17/22", "74", "9", "0", "9", "22", "0.4091",
                    "1", "1", "Yes" },
            { "5th & Oak / US Bank Tower", "Portland, OR", "OR", "No", "3/4/22", "5/17/22", "74", "5", "0", "5", "6",
                    "0.8333", "1", "1", "Yes" },
            { "Westmoreland", "Portland, OR", "OR", "No", "3/18/22", "5/24/22", "67", "9", "1", "10", "13", "0.7692",
                    "0.8", "0.9", "Yes" },
            { "Garden Home", "Portland, OR", "OR", "No", "1/31/22", "6/2/22", "122", "12", "1", "13", "19", "0.6842",
                    "0.8462", "0.9231", "Yes" },
            { "Walker & Schendel", "Beaverton, OR", "OR", "No", "1/31/22", "6/2/22", "122", "12", "5", "17", "26",
                    "0.6538", "0.4118", "0.7059", "Yes" },
            { "Jenkins at Cedar Hills Crossing", "Beaverton, OR", "OR", "No", "1/31/22", "6/2/22", "122", "10", "2",
                    "12", "25", "0.48", "0.6667", "0.8333", "Yes" },
            { "N. Center Dr & Tomahawk Island Dr", "Portland, OR", "OR", "No", "3/30/22", "6/7/22", "69", "15", "5",
                    "20", "25", "0.8", "0.5", "0.75", "Yes" },
            { "Kearney Plaza", "Portland, OR", "OR", "No", "4/19/22", "6/23/22", "65", "8", "0", "8", "15", "0.5333",
                    "1", "1", "Yes" },
            { "28th & Burnside", "Gresham, OR", "OR", "No", "4/22/22", "6/28/22", "67", "14", "3", "17", "29", "0.5862",
                    "0.6471", "0.8235", "Yes" },
            { "Clackamas Crossing", "Happy Valley, OR", "OR", "No", "5/2/22", "7/8/22", "67", "13", "0", "13", "28",
                    "0.4643", "1", "1", "Yes" },
            { "Bloomfield, Liberty Ave", "Pittsburgh, PA", "PA", "No", "1/7/22", "4/13/22", "96", "20", "0", "20", "22",
                    "0.9091", "1", "1", "Yes" },
            { "Amos Hall", "Pittsburgh, PA", "PA", "No", "3/4/22", "5/6/22", "63", "10", "3", "13", "44", "0.2955",
                    "0.5385", "0.7692", "Yes" },
            { "20th & Market", "Philadelphia, PA", "PA", "No", "2/3/22", "5/25/22", "111", "11", "0", "11", "18",
                    "0.6111", "1", "1", "Yes" },
            { "Penn Medicine Perelman Center", "Philadelphia, PA", "PA", "No", "3/16/22", "5/25/22", "70", "10", "1",
                    "11", "26", "0.4231", "0.8182", "0.9091", "Yes" },
            { "Walnut & 34th", "Philadelphia, PA", "PA", "No", "2/3/22", "5/25/22", "111", "10", "0", "10", "24",
                    "0.4167", "1", "1", "Yes" },
            { "9th & South", "Philadelphia, PA", "PA", "No", "1/28/22", "5/25/22", "117", "7", "2", "9", "17", "0.5294",
                    "0.5556", "0.7778", "Yes" },
            { "Callowhill", "Philadelphia, PA", "PA", "No", "1/28/22", "5/25/22", "117", "4", "10", "14", "19",
                    "0.7368", "-0.4286", "0.2857", "No" },
            { "Market Square", "Pittsburgh, PA", "PA", "No", "3/23/22", "5/26/22", "64", "8", "1", "9", "23", "0.3913",
                    "0.7778", "0.8889", "Yes" },
            { "Eastside", "Pittsburgh, PA", "PA", "No", "4/18/22", "6/16/22", "59", "10", "0", "10", "15", "0.6667",
                    "1", "1", "Yes" },
            { "Penn Center East", "Pittsburgh, PA", "PA", "No", "4/13/22", "6/16/22", "64", "15", "6", "21", "36",
                    "0.5833", "0.4286", "0.7143", "Yes" },
            { "12th St. & Walnut", "Philadelphia, PA", "PA", "No", "4/13/22", "6/21/22", "69", "6", "1", "7", "14",
                    "0.5", "0.7143", "0.8571", "Yes" },
            { "Greengate Centre", "Greensburg, PA", "PA", "No", "5/16/22", "6/21/22", "36", "21", "6", "27", "30",
                    "0.9", "0.5556", "0.7778", "Yes" },
            { "Craig Street", "Pittsburgh, PA", "PA", "No", "3/23/22", "6/28/22", "97", "9", "8", "17", "29", "0.5862",
                    "0.0588", "0.5294", "Yes" },
            { "I-85 & Pelham Pkwy", "Greeneville, SC", "SC", "Yes", "2/16/22", "5/16/22", "89", "8", "1", "9", "29",
                    "0.3103", "0.7778", "0.8889", "Yes" },
            { "Millwood Ave & Butler St.", "Columbia, SC", "SC", "Yes", "3/16/22", "5/26/22", "71", "12", "0", "12",
                    "28", "0.4286", "1", "1", "Yes" },
            { "I-85 & Clemson Blvd", "Anderson, SC", "SC", "Yes", "3/22/22", "5/31/22", "70", "18", "0", "18", "22",
                    "0.8182", "1", "1", "Yes" },
            { "I-75 at Merchant Drive", "Knoxville, TN", "TN", "Yes", "12/27/21", "3/29/22", "92", "8", "7", "15", "27",
                    "0.5556", "0.0667", "0.5333", "Yes" },
            { "Kingston Pike & Montvue", "Knoxville, TN", "TN", "Yes", "3/14/22", "5/26/22", "73", "13", "4", "17",
                    "33", "0.5152", "0.5294", "0.7647", "Yes" },
            { "Fortress and John Rice", "Murfreesboro, TN", "TN", "Yes", "3/14/22", "5/27/22", "74", "12", "16", "28",
                    "36", "0.7778", "-0.1429", "0.4286", "No" },
            { "Poplar & Highland", "Memphis, TN", "TN", "Yes", "1/17/22", "6/7/22", "141", "11", "3", "14", "20", "0.7",
                    "0.5714", "0.7857", "Yes" },
            { "45th & N. Lamar", "Austin, TX", "TX", "Yes", "3/21/22", "6/3/22", "74", "10", "1", "11", "26", "0.4231",
                    "0.8182", "0.9091", "Yes" },
            { "W. 24th & Nueces (White House)", "Austin, TX", "TX", "Yes", "3/8/22", "6/10/22", "94", "10", "2", "12",
                    "34", "0.3529", "0.6667", "0.8333", "Yes" },
            { "410 & Vance Jackson", "San Antonio, TX", "TX", "Yes", "2/7/22", "6/14/22", "127", "10", "6", "16", "28",
                    "0.5714", "0.25", "0.625", "Yes" },
            { "Houston & St. Mary's", "San Antonio, TX", "TX", "Yes", "3/16/22", "6/21/22", "97", "13", "0", "13", "21",
                    "0.619", "1", "1", "Yes" },
            { "Rayzor Branch", "Denton, TX", "TX", "Yes", "3/29/22", "6/30/22", "93", "17", "5", "22", "41", "0.5366",
                    "0.5455", "0.7727", "Yes" },
            { "Highland Dr and Fort Union Blvd", "Cottonwood Heights, UT", "UT", "Yes", "3/31/22", "6/10/22", "71",
                    "11", "6", "17", "20", "0.85", "0.2941", "0.6471", "Yes" },
            { "Huntsman Square", "Springfield, VA", "VA", "Yes", "2/22/22", "4/14/22", "51", "8", "10", "18", "22",
                    "0.8182", "-0.1111", "0.4444", "No" },
            { "Midlothian & Carmia Way", "Richmond, VA", "VA", "Yes", "1/19/22", "4/19/22", "90", "22", "3", "25", "29",
                    "0.8621", "0.76", "0.88", "Yes" },
            { "Broad and Willow Lawn", "Richmond, VA", "VA", "Yes", "2/22/22", "4/19/22", "56", "19", "0", "19", "28",
                    "0.6786", "1", "1", "Yes" },
            { "Forest Hill Ave", "Richmond, VA", "VA", "Yes", "1/19/22", "4/19/22", "90", "17", "1", "18", "23",
                    "0.7826", "0.8889", "0.9444", "Yes" },
            { "Westchester Commons", "Midlothian, VA", "VA", "Yes", "2/14/22", "4/19/22", "64", "13", "8", "21", "31",
                    "0.6774", "0.2381", "0.619", "Yes" },
            { "Huguenot Village Shopping Center", "Richmond, VA", "VA", "Yes", "2/14/22", "4/19/22", "64", "11", "2",
                    "13", "28", "0.4643", "0.6923", "0.8462", "Yes" },
            { "Gallows and Gatehouse", "Falls Church, VA", "VA", "Yes", "3/8/22", "4/22/22", "45", "30", "2", "32",
                    "36", "0.8889", "0.875", "0.9375", "Yes" },
            { "Leesburg Plaza", "Leesburg, VA", "VA", "Yes", "3/8/22", "4/23/22", "46", "24", "1", "25", "30", "0.8333",
                    "0.92", "0.96", "Yes" },
            { "2003 S. Main St", "Farmville, VA", "VA", "Yes", "2/22/22", "5/3/22", "70", "12", "3", "15", "27",
                    "0.5556", "0.6", "0.8", "Yes" },
            { "Oyster Point Shoppes", "Newport News, VA", "VA", "Yes", "4/8/22", "5/19/22", "41", "11", "7", "18", "18",
                    "1", "0.2222", "0.6111", "Yes" },
            { "Nuckols Rd & Twin Hickory", "Glen Allen, VA", "VA", "Yes", "4/14/22", "6/10/22", "57", "7", "20", "27",
                    "31", "0.871", "-0.4815", "0.2593", "No" },
            { "The Bridges Roanoke", "Roanoke, VA", "VA", "Yes", "2/14/22", "6/27/22", "133", "14", "0", "14", "26",
                    "0.5385", "1", "1", "Yes" },
            { "Cascade Marketplace", "Sterling, VA", "VA", "Yes", "5/17/22", "6/28/22", "42", "11", "4", "15", "17",
                    "0.8824", "0.4667", "0.7333", "Yes" },
            { "Arthur Ashe Blvd & Myers", "Richmond, VA", "VA", "Yes", "2/14/22", "6/30/22", "136", "8", "7", "15",
                    "22", "0.6818", "0.0667", "0.5333", "Yes" },
            { "Broadway & Denny", "Seattle, WA", "WA", "No", "12/20/21", "3/22/22", "92", "9", "0", "9", "13", "0.6923",
                    "1", "1", "Yes" },
            { "Starbucks Reserve Roastery", "Seattle, WA", "WA", "No", "2/14/22", "4/21/22", "66", "38", "27", "65",
                    "104", "0.625", "0.1692", "0.5846", "Yes" },
            { "Cooper Point Village", "Olympia, WA", "WA", "No", "2/26/22", "4/29/22", "62", "19", "2", "21", "30",
                    "0.7", "0.8095", "0.9048", "Yes" },
            { "Holman Rd", "Seattle, WA", "WA", "No", "2/24/22", "4/29/22", "64", "11", "1", "12", "14", "0.8571",
                    "0.8333", "0.9167", "Yes" },
            { "2344 Eastlake", "Seattle, WA", "WA", "No", "3/18/22", "5/27/22", "70", "12", "0", "12", "15", "0.8", "1",
                    "1", "Yes" },
            { "505 Union Station", "Seattle, WA", "WA", "No", "3/16/22", "5/27/22", "72", "6", "3", "9", "15", "0.6",
                    "0.3333", "0.6667", "Yes" },
            { "37th & Broadway", "Everett, WA", "WA", "No", "1/31/22", "6/1/22", "121", "13", "1", "14", "29", "0.4828",
                    "0.8571", "0.9286", "Yes" },
            { "5th & Pike", "Seattle, WA", "WA", "No", "1/25/22", "6/6/22", "132", "12", "0", "12", "15", "0.8", "1",
                    "1", "Yes" },
            { "1200 Westlake Ave", "Seattle, WA", "WA", "No", "1/25/22", "6/6/22", "132", "7", "7", "14", "22",
                    "0.6364", "0", "0.5", "No" },
            { "E. Olive Way", "Seattle, WA", "WA", "No", "3/30/22", "6/7/22", "69", "8", "0", "8", "20", "0.4", "1",
                    "1", "Yes" },
            { "Capitol Blvd & Trosper St, Tumwater", "Olympia, WA", "WA", "No", "3/28/22", "6/7/22", "71", "12", "3",
                    "15", "31", "0.4839", "0.6", "0.8", "Yes" },
            { "Lakewood Crossing - Marysville", "Marysville, WA", "WA", "No", "4/11/22", "6/21/22", "71", "9", "4",
                    "13", "22", "0.5909", "0.3846", "0.6923", "Yes" },
            { "Iowa & King", "Bellingham, WA", "WA", "No", "4/15/22", "6/24/22", "70", "20", "0", "20", "30", "0.6667",
                    "1", "1", "Yes" },
            { "4147 University Way Avenue", "Seattle, WA", "WA", "No", "4/25/22", "6/28/22", "64", "10", "5", "15",
                    "32", "0.4688", "0.3333", "0.6667", "Yes" },
            { "Madison Park", "Seattle, WA", "WA", "No", "5/2/22", "6/30/22", "59", "6", "1", "7", "18", "0.3889",
                    "0.7143", "0.8571", "Yes" },
            { "Cordata Center", "Bellingham, WA", "WA", "No", "5/10/22", "7/6/22", "57", "10", "3", "13", "25", "0.52",
                    "0.5385", "0.7692", "Yes" },
            { "Howell & Puetz", "Oak Creek, WI", "WI", "Yes", "2/14/22", "4/27/22", "72", "15", "8", "23", "31",
                    "0.7419", "0.3043", "0.6522", "Yes" },
            { "McDill & Crossroads", "Plover, WI", "WI", "Yes", "2/21/22", "5/4/22", "72", "7", "5", "12", "34",
                    "0.3529", "0.1667", "0.5833", "Yes" },
            { "Northland & Richmond", "Appleton, WI", "WI", "Yes", "4/8/22", "6/16/22", "69", "10", "7", "17", "24",
                    "0.7083", "0.1765", "0.5882", "Yes" },
            { "Capitol Square - Main & MLK", "Madison, WI", "WI", "Yes", "3/29/22", "6/30/22", "93", "15", "1", "16",
                    "22", "0.7273", "0.875", "0.9375", "Yes" } };

    /**
     * Performs a run using all of the data and displaying some of the data.
     * 
     * @param args not used.
     */
    public static void main(String[] args)
    {
        StarbucksCorporation starbucksCorporation = null;
        // Try creating a StarbucksCorporation object that is too small
        System.out.println("Try creating a StarbucksCorporation object that is too small:");
        starbucksCorporation = new StarbucksCorporation(StarbucksCorporation.MIN_NUM_STORES - 1);
        if (starbucksCorporation.allStores.length != MIN_NUM_STORES)
        {
            System.err.println(
                    "You must define a StarbucksCorporation constructor which initializes the instance variable allStores to be "
                            + "user's requested size if greater than MIN_NUM_STORES. The length of allStores should be "
                            + "MIN_NUM_STORES otherwise.");
        }
        // Create a useful StarbucksCorporation object using the sample data
        System.out.println("\nCreate a useful StarbucksCorporation object using the sample data:");
        starbucksCorporation = new StarbucksCorporation(COMPLETE_CSV_DATA_IN_ROWS.length);
        starbucksCorporation.loadAllData();
        System.out.println("There are " + starbucksCorporation.sizeOfCorporation() + " stores available.");
        StarbucksStore store = null;
        int[] storeNumbers =
        { -1, 0, 1, 20, COMPLETE_CSV_DATA_IN_ROWS.length }; // Don't change this array!
        for (int storeNumber : storeNumbers)
        {
            System.out.println("\nDetails of store number " + storeNumber + ":");
            // TODO: Catch IndexOutOfBoundsException
            store = starbucksCorporation.getStoreNumber(storeNumber);
            store.printStore();
        }
    }

    // TODO: Complete method signature to receive an argument for the expected
    // number of stores.
    // Should construct an object of type StarbucksCorporation by initializing the
    // instance
    // variable "allStores".
    // If the value for expected number of stores is less than MIN_NUM_STORES, then
    // initialize allStores to be hold MIN_NUM_STORES number of StarbucksStore
    // objects.
    public StarbucksCorporation(/* TODO: complete method signature */)
    {
        // TODO: Initialize attribute(s)
    }

    // TODO: Complete the method to add a Starbuck object to "allStores" array.
    // Return true if there was space to add the StarbucksStore and the
    // store object is not null.
    // Otherwise, returns false to indicate the store was not added.
    public boolean addStore(/* TODO: complete method signature */)
    {
    }

    // TODO: Define a getter (i.e. Accessor) method for "allStores"
    // to receive zero arguments and to return a one-dimensional array
    // StarbucksStores in the original order stored.
    public StarbucksStore[] getAllStores()
    {
    }

    // TODO: Define a getter (i.e. accessor) method for the number of stores with
    // Right-to-Work laws.
    // Receives zero arguments and returns a value of type int.
    public int getNumRTW()
    {
    }

    // TODO: Define a getter (i.e. accessor) method for the number of stores that
    // have a yes
    // for the result of the vote
    // Receives zero arguments and returns a value of type int.
    public int getNumYesVoteResults()
    {
    }

    // TODO: Define a getter (i.e. Accessor) method for the name of stores.
    // Receive zero arguments and returns a one-dimensional array with
    // the name of stores in the original order stored.
    public String[] getStoreNames()
    {
    }

    // TODO: Define a getter (i.e. accessor) method that returns a Starbucks store
    // to receive the requested index of the Starbucks store where indices start at
    // zero,
    // returns the Starbucks store at the specied position if it exists.
    public StarbucksStore getStoreNumber(int requestedStoreNumber) throws IndexOutOfBoundsException
    {
    }

    /**
     * Initializes an array of type Starbucks to hold a fixed number of objects.
     */
    public void loadAllData()
    {
        for (String[] data : COMPLETE_CSV_DATA_IN_ROWS)
        {
            StarbucksStore store;

            String storeName = data[0];
            String storeLocation = data[1];
            String stateAbbreviation = data[2];
            boolean hasRightToWork = data[3].equals("Yes");
            int numVotesYes = Integer.parseInt(data[7]);
            int numVotesNo = Integer.parseInt(data[8]);
            boolean result = data[14].equals("Yes");

            // Initializes a Starbucks object
            store = new StarbucksStore(storeName, storeLocation, stateAbbreviation, hasRightToWork, numVotesYes,
                    numVotesNo, result);

            // Add the store to this corporation
            this.addStore(store);
        } // end of iterating over all data
    }

    // TODO: Define a method called printAllStores which receives zero
    // arguments and does not return anything.
    // Prints to standard out a String representation of the number of stores
    // and a String representation of all the stores.
    public void printAllStores()
    {
    }

    // TODO: Define a getter (i.e. Accessor) method for the number of elements in
    // "allStores"
    // to receive zero arguments and to return an int.
    public int sizeOfCorporation()
    {
    }
}